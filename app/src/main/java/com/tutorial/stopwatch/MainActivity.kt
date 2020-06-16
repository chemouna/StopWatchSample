package com.tutorial.stopwatch

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    private var isTimerRunning = false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        start.setOnClickListener {
            if (isTimerRunning) {
                timer.stop()
                start.text = getString(R.string.start)
                isTimerRunning = false
            } else {
                timer.start()
                start.text = getString(R.string.stop)
                isTimerRunning = true
            }
        }
    }
}