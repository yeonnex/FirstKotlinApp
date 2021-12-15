package com.yeonnex.lionapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.yeonnex.lionapp.databinding.ActivityEventBinding

// 안드로이드 이벤트 처리 개요

class EventActivity : AppCompatActivity() {
    private lateinit var binding: ActivityEventBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityEventBinding.inflate(layoutInflater)
        setContentView(binding.root)

//        binding.btnEvent.setOnClickListener(object : View.OnClickListener{
//            override fun onClick(v: View?) {
//                binding.tvStatus.text = "button clicked"
//            }
//        })

        binding.btnEvent.setOnClickListener {
            binding.tvStatus.text = "button clicked"
        }

        binding.btnEvent.setOnLongClickListener {
            binding.tvStatus.text = "Long Button clicked"
            true // 이벤트를 소비했다는 것을 나타냄
//            false 이벤트를 완전히 소비하지 않고 같은 타입 리스너에게 계속 전달
        }

    }
}