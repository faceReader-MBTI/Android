package com.example.mbti_app.resultSection

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

import com.example.mbti_app.databinding.ResultRightActivityBinding

class RightResultActivity : AppCompatActivity() {

    // XML ViewBinding
    private val viewBinding: ResultRightActivityBinding by lazy {
        ResultRightActivityBinding.inflate(layoutInflater)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(viewBinding.root)

        // 확인 버튼 클릭
        viewBinding.btnNext.setOnClickListener {
            val intent = Intent(this, FinalResultActivity::class.java)
            startActivity(intent)
            finish()
        }

    }
}