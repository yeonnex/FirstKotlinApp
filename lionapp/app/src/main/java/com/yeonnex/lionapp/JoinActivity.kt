package com.yeonnex.lionapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.yeonnex.lionapp.databinding.ActivityJoinBinding

class JoinActivity : AppCompatActivity() {
    private lateinit var binding: ActivityJoinBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityJoinBinding.inflate(layoutInflater)
        setContentView(R.layout.activity_join)

        val extras = intent.extras ?: return
        val id = extras.getString("id")
        binding.etID.setText(id)

        binding.btnOK.setOnClickListener{
            val id = binding.etID.text.toString()
            val data = Intent()
            data.putExtra("returnData", id)
            setResult(RESULT_OK, data)
            super.finish()
        }
    }
}