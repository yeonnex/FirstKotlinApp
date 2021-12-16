package com.yeonnex.lionapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.oz10.lionapp.MainActivity
import com.yeonnex.lionapp.databinding.ActivityHomeBinding

class HomeActivity : AppCompatActivity() {
    private lateinit var binding:ActivityHomeBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)
        binding.button11.setOnClickListener {
            startActivity(Intent(this, MainActivity::class.java))
        }
        binding.button12.setOnClickListener {
            startActivity(Intent(this,CountActivity::class.java))
        }
    }
}