package com.yeonnex.lionapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.yeonnex.lionapp.databinding.ActivityStateChangeBinding


class StateChangeActivity : AppCompatActivity() {
    val TAG = "StateChange"
    private lateinit var binding :ActivityStateChangeBinding
    val sharedPreferences = getSharedPreferences("lion", 0)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_state_change)

        Log.i(TAG, "onCreate")
    }

    override fun onStart() {
        super.onStart()
        Log.i(TAG, "onStart")
    }

    override fun onPause() {
        super.onPause()
        Log.i(TAG, "onPause")
    }

    override fun onStop() {
        super.onStop()
        Log.i(TAG, "onStop")
    }

    override fun onRestart() {
        super.onRestart()
        Log.i(TAG, "onRestart")
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.i(TAG, "onDestroy")
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        Log.i(TAG, "onSaveInstanceState")

        val userText = binding.editText.text.toString()
        outState.putCharSequence("savedText", userText)

        val editor = sharedPreferences.edit()
        editor.putString("savedText", userText)
        editor.apply() // 세이브! 커밋!
    }

    override fun onRestoreInstanceState(savedInstanceState: Bundle) {
        super.onRestoreInstanceState(savedInstanceState)
        Log.i(TAG, "onRestoreInstanceState")
        val userText = sharedPrefences.getString("savedText", "")
        binding.editText.setText(userText)
    }
}