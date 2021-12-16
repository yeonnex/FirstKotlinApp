package com.yeonnex.lionapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.yeonnex.lionapp.databinding.ActivityLoginBinding

// 안드로이드 화면 전환과 값 전달
// 화면과 화면간의 통신
// 인텐트 개요
//  인텐트는 하나의 액티비티가 다른 액티비티를 시작시킬 수 있는 메시징 시스템

class LoginActivity : AppCompatActivity() {
    private lateinit var binding: ActivityLoginBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLoginBinding.inflate(layoutInflater)
        setContentView(R.layout.activity_login)

        binding.btnLogin.setOnClickListener {
            val id = binding.etID.text.toString()
            val intent = Intent(this@LoginActivity, MemberActivity::class.java)
            intent.putExtra("id", id)
            startActivity(intent)
        }
    }
}