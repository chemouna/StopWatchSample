package com.tutorial.stopwatch

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class MainViewModel: ViewModel() {

    private val isTimerRunning: MutableLiveData<Boolean> = MutableLiveData()
    private val timerBase: MutableLiveData<Long> = MutableLiveData()
    private var stopDiff: Long = 0

    init {
        timerBase.value = 0
    }

    fun timerState(): LiveData<Boolean> = isTimerRunning
    fun timerBase(): LiveData<Long> = timerBase

    fun toggleTimer(elapsedTime: Long) {
        if (isTimerRunning.value == true) {
            stopTimer(elapsedTime)
        } else {
            startTimer(elapsedTime)
        }
    }

    private fun startTimer(elapsedTime: Long) {
        isTimerRunning.value = true
        timerBase.value = elapsedTime - stopDiff
    }

    private fun stopTimer(elapsedTime: Long) {
        isTimerRunning.value = false
        stopDiff = elapsedTime - (timerBase.value ?: 0)
    }

    fun resetTimer(elapsedTime: Long) {
        isTimerRunning.value = false
        stopDiff = 0
        timerBase.value = elapsedTime
    }
}