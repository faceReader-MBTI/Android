package com.example.mbti_app.resultSection

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.mbti_app.cameraSection.CameraActivity
import com.example.mbti_app.databinding.ResultFinalActivityBinding
import com.example.mbti_app.logoSection.MainActivity
import com.example.mbti_app.mbtiSection.IntrovertActivity


class FinalResultActivity : AppCompatActivity() {

    // XML ViewBinding
    private val viewBinding: ResultFinalActivityBinding by lazy {
        ResultFinalActivityBinding.inflate(layoutInflater)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(viewBinding.root)


        // 처음으로 버튼 클릭
        viewBinding.btnNext2.setOnClickListener {


            // TO DO
            /*

                사용자의 Img 데이터와
                사용자의 MBTI 입력 값을 DB에 저장해야함.

                올바른 형식으로 MBTI 입력했을 시 DB에 성공적으로 저장 후
                첫화면으로 화면 전환 {예외처리는 백엔드에서 진행}
            */
            var userMbti = viewBinding.editUserMbti.text.toString()

            val intent = Intent(this, MainActivity::class.java)
            intent.putExtra("UserMbti", userMbti)
            startActivity(intent)
            finish()
        }

    }
}