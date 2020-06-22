package com.tutorial.stopwatch

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val viewModel = ViewModelProvider(this)[MainViewModel::class.java]
        viewModel.timerState().observe(this, Observer { isRunning ->
            if (isRunning) {
                timer.start()
                toggle_timer.text = getString(R.string.stop)
            } else {
                timer.stop()
                toggle_timer.text = getString(R.string.start)
            }
        })

        viewModel.timerBase().observe(this, Observer { time ->
            timer.base = time
        })

        toggle_timer.setOnClickListener {
            viewModel.toggleTimer()
        }

        reset_timer.setOnClickListener {
            viewModel.resetTimer()
        }
    }
}