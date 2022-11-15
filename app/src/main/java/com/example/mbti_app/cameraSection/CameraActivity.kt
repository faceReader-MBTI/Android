package com.example.mbti_app.cameraSection

import android.app.Activity
import android.content.Intent
import android.content.pm.PackageManager
import android.graphics.ImageDecoder
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.MediaStore
import android.widget.Button
import android.widget.ImageView
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat
import androidx.core.content.FileProvider
import com.example.mbti_app.R
import com.example.mbti_app.mbtiSection.IntrovertActivity
import java.io.File
import java.text.SimpleDateFormat
import kotlin.system.exitProcess

class CameraActivity : AppCompatActivity(), OnCautionOKClickListener{
    val PERMISSIONS = arrayOf(
        android.Manifest.permission.CAMERA,
        android.Manifest.permission.WRITE_EXTERNAL_STORAGE,
        android.Manifest.permission.READ_EXTERNAL_STORAGE
    )
    val PERMISSIONS_REQUEST = 200
    val Btn_OK = 20
    private var photoUri: Uri? = null
    lateinit var imagePhoto:ImageView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_camera)
        checkPermissions(PERMISSIONS, PERMISSIONS_REQUEST)
        val btnCamera = findViewById<Button>(R.id.btn_camera)
        val btnAnalyze = findViewById<Button>(R.id.btn_analyze)

        imagePhoto = findViewById<ImageView>(R.id.image_camera)

        btnCamera.setOnClickListener {
            CautionFragment(this).show(
                supportFragmentManager, "CameraDialog"
            )
        }
        btnAnalyze.setOnClickListener {
            if(false){
                ErrPersonFragment().show(
                    supportFragmentManager, "ErrPersonDialog"
                )
            }
            else if(false){
                ErrMaskFragment().show(
                    supportFragmentManager, "ErrMaskDialog"
                )
            }
            else{
                val introvertActivity = Intent(this, IntrovertActivity::class.java)
                startActivity(introvertActivity)
                finish()
            }
        }
    }
    fun CallCamera(){
        val takeScreenIntent = Intent(MediaStore.ACTION_IMAGE_CAPTURE)
        val photoFile = File(
            File("${filesDir}/image").apply{
                if(!this.exists()){
                    this.mkdirs()
                }
            },
            newJpgFileName()
        )
        photoUri=FileProvider.getUriForFile(
            this,
            "com.example.mbti_app.fileprovider",
            photoFile
        )
        takeScreenIntent.resolveActivity(packageManager).also {
            takeScreenIntent.putExtra(MediaStore.EXTRA_OUTPUT, photoUri)
            startActivityForResult(takeScreenIntent, Btn_OK)
        }
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if(resultCode==Activity.RESULT_OK){
            when(requestCode){
                Btn_OK->{
                    val imageBitmap = photoUri?.let { ImageDecoder.createSource(this.contentResolver, it) }
                    imagePhoto.setImageBitmap(imageBitmap?.let { ImageDecoder.decodeBitmap(it) })
//                    Toast.makeText(this, photoUri?.path, Toast.LENGTH_LONG).show()
                }
            }
        }
    }
    override fun onRequestPermissionsResult(
        requestCode: Int,
        permissions: Array<out String>,
        grantResults: IntArray
    ) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults)
        for(result in grantResults){
            if(result != PackageManager.PERMISSION_GRANTED){
                exitProcess(0)
            }
        }
    }
    private fun newJpgFileName() : String {
        val sdf = SimpleDateFormat("yyyyMMdd_HHmmss")
        val filename = sdf.format(System.currentTimeMillis())
        return "${filename}.jpg"
    }
    private fun checkPermissions(permissions: Array<String>, permissionsRequest: Int): Boolean {
        val permissionList : MutableList<String> = mutableListOf()
        for(permission in permissions){
            val result = ContextCompat.checkSelfPermission(this, permission)
            if(result != PackageManager.PERMISSION_GRANTED){
                permissionList.add(permission)
            }
        }
        if(permissionList.isNotEmpty()){
            ActivityCompat.requestPermissions(this, permissionList.toTypedArray(), PERMISSIONS_REQUEST)
            return false
        }
        return true
    }
    override fun onOKClikListener() {
        CallCamera()
    }

}