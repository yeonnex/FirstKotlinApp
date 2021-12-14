package com.yeonnex.lionapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.yeonnex.lionapp.databinding.ActivityCountBinding
import com.yeonnex.lionapp.databinding.ActivityMockBinding

class MockActivity : AppCompatActivity() {
    private lateinit var binding:ActivityMockBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMockBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnChatSend.setOnClickListener {
            var msg = binding.etChatMsg.text.toString()
            binding.tvMsg.append(msg + "\n")
            binding.etChatMsg.setText("")
        }
    }
}