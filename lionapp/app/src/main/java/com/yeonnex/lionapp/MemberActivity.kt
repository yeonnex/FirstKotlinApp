package com.yeonnex.lionapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.yeonnex.lionapp.databinding.ActivityMemberBinding

class MemberActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMemberBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMemberBinding.inflate(layoutInflater)
        setContentView(R.layout.activity_member)

        val extras = intent.extras?: return
        val id = extras.getString("id")
        binding.tvHello.text = id + "님 환영합니다!"
    }
}