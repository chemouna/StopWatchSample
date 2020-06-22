package com.tutorial.stopwatch

import android.os.SystemClock
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class MainViewModel: ViewModel() {

    private val isTimerRunning: MutableLiveData<Boolean> = MutableLiveData()
    private val timerBase: MutableLiveData<Long> = MutableLiveData()
    private var stopDiff: Long = 0

    init {
        timerBase.value = SystemClock.elapsedRealtime()
    }

    fun timerState(): LiveData<Boolean> = isTimerRunning
    fun timerBase(): LiveData<Long> = timerBase

    fun toggleTimer() {
        if (isTimerRunning.value == true) {
            stopTimer()
        } else {
            startTimer()
        }
    }

    private fun startTimer() {
        isTimerRunning.value = true
        timerBase.value = SystemClock.elapsedRealtime() - stopDiff
    }

    private fun stopTimer() {
        isTimerRunning.value = false
        stopDiff = SystemClock.elapsedRealtime() - (timerBase.value ?: 0)
    }

    fun resetTimer() {
        isTimerRunning.value = false
        stopDiff = 0
        timerBase.value = SystemClock.elapsedRealtime()
    }
}