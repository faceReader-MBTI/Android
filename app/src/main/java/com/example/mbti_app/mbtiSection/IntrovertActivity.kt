package com.example.mbti_app.mbtiSection

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

import com.example.mbti_app.databinding.MbtiIntrovertActivityBinding

class IntrovertActivity : AppCompatActivity() {

    // XML ViewBinding
    private val viewBinding: MbtiIntrovertActivityBinding by lazy {
        MbtiIntrovertActivityBinding.inflate(layoutInflater)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(viewBinding.root)

        // 다음 버튼 클릭 시 이벤트 처리
        viewBinding.btnNext.setOnClickListener {
            val intent = Intent(this, AnswerActivity::class.java)
            startActivity(intent)
        }

    }
}