package com.yeonnex.lionapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.LinearLayout
import com.oz10.lionapp.MainActivity
import com.yeonnex.lionapp.databinding.ActivityHomeBinding

class HomeActivity : AppCompatActivity() {
    private lateinit var binding:ActivityHomeBinding
    private val buttons = mutableMapOf<String, Class<*>>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)

        buttons["Lion"] = MainActivity::class.java
        buttons["Count"] = CountActivity::class.java

        val params = LinearLayout.LayoutParams(
            LinearLayout.LayoutParams.MATCH_PARENT,
            LinearLayout.LayoutParams.WRAP_CONTENT,
        )

        for (key in buttons.keys){
            val btn = Button(this)
            btn.text = key
            btn.layoutParams =params
            btn.setOnClickListener {startActivity(Intent(this, buttons[key]))}
            binding.layoutMenu.addView(btn)
        }
    }
}