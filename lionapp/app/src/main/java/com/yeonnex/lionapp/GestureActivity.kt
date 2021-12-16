package com.yeonnex.lionapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.GestureDetector
import android.view.MotionEvent
import androidx.core.view.GestureDetectorCompat
import com.yeonnex.lionapp.databinding.ActivityGestureBinding

// 안드로이드 제스쳐
// 리스너 클래스 구현하기
// GestureDetector.OnGestureListerner, ... 상속 받아야 함
// 클래스는 상속 하나만 받을 수 있지만, 인터페이스는 여러개 상속 가능!

//   GestureDetector.OnGestureListener, GestureDetector.OnDoubleTapListener

class GestureActivity : AppCompatActivity(),
    GestureDetector.OnGestureListener, GestureDetector.OnDoubleTapListener {
    private lateinit var binding: ActivityGestureBinding
    var gestureDetector: GestureDetectorCompat? = null
    val TAG = "GestureEvent"
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityGestureBinding.inflate(layoutInflater)
        setContentView(binding.root)

        this.gestureDetector = GestureDetectorCompat(this, this)
        this.gestureDetector?.setOnDoubleTapListener(this)
    }
    override fun onTouchEvent(event: MotionEvent?):Boolean{
        this.gestureDetector?.onTouchEvent(event)
        Log.i(TAG, "onTouchEvent")
        return super.onTouchEvent(event)
    }
    override fun onDown(e: MotionEvent?): Boolean {
        binding.tvGestureStatus.text = "onDown"
        Log.i(TAG, "onTouchEvent")

        return true
    }

    override fun onShowPress(e: MotionEvent?) {
        binding.tvGestureStatus.text = "onShowPress"
        Log.i(TAG, "onTouchEvent")

    }

    override fun onSingleTapUp(e: MotionEvent?): Boolean {
        binding.tvGestureStatus.text = "onSingleTapUp"
        Log.i(TAG, "onTouchEvent")

        return true
    }

    override fun onScroll(
        e1: MotionEvent?,
        e2: MotionEvent?,
        distanceX: Float,
        distanceY: Float
    ): Boolean {
        binding.tvGestureStatus.text = "onScroll"
        Log.i(TAG, "onTouchEvent")

        return true
    }

    override fun onLongPress(e: MotionEvent?) {
        binding.tvGestureStatus.text = "onLongPress"
        Log.i(TAG, "onTouchEvent")
    }

    override fun onFling(
        e1: MotionEvent?,
        e2: MotionEvent?,
        velocityX: Float,
        velocityY: Float
    ): Boolean {
        binding.tvGestureStatus.text = "onFling"
        Log.i(TAG, "onTouchEvent")
        return true
    }

    override fun onSingleTapConfirmed(e: MotionEvent?): Boolean {
        binding.tvGestureStatus.text = "onSingleTapConfirmed"
        Log.i(TAG, "onTouchEvent")
        return true
    }

    override fun onDoubleTap(e: MotionEvent?): Boolean {
        binding.tvGestureStatus.text = "onDoubleTap"
        Log.i(TAG, "onTouchEvent")
        return true
    }

    override fun onDoubleTapEvent(e: MotionEvent?): Boolean {
        binding.tvGestureStatus.text = "onDoubleTapEvent"
        Log.i(TAG, "onTouchEvent")
        return true
    }
}
