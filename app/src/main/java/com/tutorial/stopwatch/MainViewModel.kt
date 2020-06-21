package com.tutorial.stopwatch

import android.os.SystemClock
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class MainViewModel: ViewModel() {

    private val isTimerRunning: MutableLiveData<Boolean> = MutableLiveData(false)
    private val elapsedTime: MutableLiveData<Long> = MutableLiveData(0)
    private var startOffset: Long = 0

    init {
        elapsedTime.value = SystemClock.elapsedRealtime()
    }

    fun timerState(): LiveData<Boolean> = isTimerRunning
    fun startTime(): LiveData<Long> = elapsedTime

    fun toggleTimer() {
        if (isTimerRunning.value == true) {
            stopTimer()
        } else {
            startTimer()
        }
    }

    private fun startTimer() {
        isTimerRunning.value = true
        elapsedTime.value = SystemClock.elapsedRealtime() - startOffset
    }

    private fun stopTimer() {
        isTimerRunning.value = false
        startOffset = SystemClock.elapsedRealtime()
    }

}