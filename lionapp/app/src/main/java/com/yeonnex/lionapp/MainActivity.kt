package com.yeonnex.lionapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

//        btnSend.setOnClickListener(object : View.OnClickListener{
//            override fun onClick(v: View?){
//                val msg = etMsg.text.toString()
//                tvHello.text = msg
//                etMsg.setText("")
//            }
//        })

        btnSend.setOnClickListener{
            val msg = etMsg.text.toString()
            tvHello.text = msg
            etMsg.setText("")
        }
    }

}

