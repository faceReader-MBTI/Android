package com.example.mbti_app.LogoSection

import android.content.pm.PackageManager
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.core.app.ActivityCompat
import com.example.mbti_app.R
import java.util.jar.Manifest

class MainActivity : AppCompatActivity() {
    private val myCameraPermission = 100

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        onCheckPermission();
    }
    private fun onCheckPermission(){
        if(ActivityCompat.checkSelfPermission(this, android.Manifest.permission.CAMERA)!=PackageManager.PERMISSION_GRANTED){
            var permissions = arrayOf(
                android.Manifest.permission.CAMERA
            )
            ActivityCompat.requestPermissions(this, permissions, myCameraPermission)
        }
    }

    override fun onRequestPermissionsResult(
        requestCode: Int,
        permissions: Array<out String>,
        grantResults: IntArray
    ) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults)

        if(requestCode === myCameraPermission){
            if(grantResults.isNotEmpty()){
                for(grant in grantResults){
                    if(grant!=PackageManager.PERMISSION_GRANTED)
                        System.exit(0)
                }
            }
        }
    }
}