package com.yeonnex.lionapp

import android.content.Intent
import android.net.Uri
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

        // 바로 람다식으로!
        btnSend.setOnClickListener{
            val msg = etMsg.text.toString()
            tvHello.text = msg
            etMsg.setText("")
        }
        // 바로 람다식으로!
        btnCall.setOnClickListener{
            val intent: Intent = Intent(Intent.ACTION_VIEW, Uri.parse("tel:010-1111-2222")) // 사진 리소스 등 모든걸 URI라고 함
            startActivity(intent)
        }
    }

}

