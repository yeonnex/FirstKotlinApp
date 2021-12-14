package com.yeonnex.lionapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.yeonnex.lionapp.databinding.ActivityCountBinding

class CountActivity : AppCompatActivity() {

    private lateinit var binding: ActivityCountBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityCountBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }
}