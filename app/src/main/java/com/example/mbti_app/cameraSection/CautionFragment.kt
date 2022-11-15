package com.example.mbti_app.cameraSection

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.fragment.app.DialogFragment
import com.example.mbti_app.R

class CautionFragment(onOKClickListener: OnCautionOKClickListener) : DialogFragment() {
    private var callbackCameraActivity:OnCautionOKClickListener

    init {
        callbackCameraActivity = onOKClickListener
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val fragmentInflater = inflater.inflate(R.layout.fragment_caution, container, false)
        fragmentInflater.findViewById<Button>(R.id.btn_attention_ok).setOnClickListener {
            callbackCameraActivity.onOKClikListener()
            dismiss()
        }
        return fragmentInflater
    }
}