package com.yeonnex.lionapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.MotionEvent
import android.view.View
import com.yeonnex.lionapp.databinding.ActivityEventBinding

// 안드로이드 이벤트 처리 개요


// 터치와 다중 터치 이벤트 처리하기
// 터치 이벤트 처리 : OnTouchListener { v: View, m:MotionEvent -> }

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

//        binding.activityMain.setOnTouchListener(object: View.OnTouchListener{
//            override fun onTouch(p0: View?, p1: MotionEvent?): Boolean {
//                TODO("Not yet implemented")
//            }
//        })
        binding.tvStatus.text = "touch log 1"
        binding.tvStatus2.text = "touch log 2"

        binding.activityMain.setOnTouchListener{v: View, m: MotionEvent ->
            handleTouch(m)
            true // 이벤트 소비 완료!
        }

    }

    private fun handleTouch(m: MotionEvent) {
        val pointerCount = m.pointerCount
        val pointerId = m.getPointerId(0)
//        binding.tvStatus.text = "pointerCount = $pointerCount, pointerId = $pointerId"
//        Log.d("Event...", "pointerCount = $pointerCount, pointerId = $pointerId")
        for (i in 0 until pointerCount){
            val x = m.getX(i)
            val y = m.getY(i)
            val id = m.getPointerId(i)
            val action = m.actionMasked
            val actionIndex = m.actionIndex
            var actionString: String
            when (action){
                MotionEvent.ACTION_DOWN -> actionString = "DOWN"
                MotionEvent.ACTION_UP -> actionString = "UP"
                MotionEvent.ACTION_POINTER_DOWN -> actionString = "POINTER_DOWN"
                MotionEvent.ACTION_POINTER_UP -> actionString = "POINTER_UP"
                MotionEvent.ACTION_MOVE -> actionString = "MOVE"
                else -> actionString = ""
            }
            val touchStatus = "Action: $actionString, Index: $actionIndex, id = $id, x=$x, y=$y"
            Log.d("Event...", touchStatus)

            if (id == 0) binding.tvStatus.text = touchStatus
            else binding.tvStatus2.text = touchStatus
        }
    }
}