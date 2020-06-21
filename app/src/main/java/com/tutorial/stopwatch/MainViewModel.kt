package com.tutorial.stopwatch

import android.os.SystemClock
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class MainViewModel: ViewModel() {

    private val isTimerRunning: MutableLiveData<Boolean> = MutableLiveData(false)
    private val timerBase: MutableLiveData<Long> = MutableLiveData(0)
    private var startOffset: Long = 0

    init {
        timerBase.value = SystemClock.elapsedRealtime()
    }

    fun timerState(): LiveData<Boolean> = isTimerRunning
    fun startTime(): LiveData<Long> = timerBase

    fun toggleTimer() {
        if (isTimerRunning.value == true) {
            stopTimer()
        } else {
            startTimer()
        }
    }

    private fun startTimer() {
        isTimerRunning.value = true
        timerBase.value = SystemClock.elapsedRealtime() - startOffset
    }

    private fun stopTimer() {
        isTimerRunning.value = false
        startOffset = SystemClock.elapsedRealtime() - (timerBase.value ?: 0)
    }

    fun resetTimer() {
        isTimerRunning.value = false
        startOffset = 0
        timerBase.value = SystemClock.elapsedRealtime()
    }
}