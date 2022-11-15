package com.example.mbti_app.mbtiSection

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.mbti_app.databinding.MbtiAnswerActivityBinding
import com.example.mbti_app.resultSection.RightResultActivity
import com.example.mbti_app.resultSection.WrongResultActivity


class AnswerActivity : AppCompatActivity() {

    // XML ViewBinding
    private val viewBinding: MbtiAnswerActivityBinding by lazy {
        MbtiAnswerActivityBinding.inflate(layoutInflater)
    }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(viewBinding.root)


        // 맞았다 버튼
        viewBinding.button.setOnClickListener {
            val intent = Intent(this, RightResultActivity::class.java)
            startActivity(intent)
        }

        // 틀렸다 버튼
        viewBinding.button2.setOnClickListener {
            val intent = Intent(this, WrongResultActivity::class.java)
            startActivity(intent)
        }

    }
}