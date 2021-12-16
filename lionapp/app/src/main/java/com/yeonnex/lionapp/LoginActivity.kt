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
    private val request_code = 5
    companion object {
        var members = mapOf("tester" to "1234", "admin" to "1234", "user" to "1234")
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLoginBinding.inflate(layoutInflater)
        setContentView(R.layout.activity_login)

        binding.btnLogin.setOnClickListener {
            val id = binding.etID.text.toString()
            val pw = binding.etID.text.toString()

            if (members.containsKey(id)) {
                if (members.get(id) != pw){
                    binding.tvMsg.text = "비번이 다릅니다."
                }else{
                    // 초기화
                    initUI()

                }
            }else{
                val intent = Intent(this@LoginActivity, JoinActivity::class.java)
                intent.putExtra("id", id)
                startActivityForResult(intent, request_code)
            }
        }
        binding.btnCancel.setOnClickListener {
            super.finish()
        }
    }

    private fun initUI() {
        binding.tvMsg.text = ""
        binding.etID.setText("")
        binding.etPW.setText("")
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if((requestCode == request_code) && (resultCode == RESULT_OK)){
            data?.let{
                if(it.hasExtra("returnData")) {
                    val returnString = it.extras?.getString("returnData")
                    binding.etID.setText(returnString)
                }
            }
        }
    }
}