package com.tutorial.stopwatch

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    // TODO: make a wrapper around Chronometer with this
    private var isTimerRunning = false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        start.setOnClickListener {
            if (isTimerRunning) {
                timer.start()
                start.text = getString(R.string.stop)
                isTimerRunning = true
            } else {
                timer.stop()
                start.text = getString(R.string.start)
                isTimerRunning = false
            }
        }
    }
}