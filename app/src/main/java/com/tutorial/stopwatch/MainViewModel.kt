package com.tutorial.stopwatch

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class MainViewModel: ViewModel() {

    private val isTimerRunning: MutableLiveData<Boolean> = MutableLiveData(false)

    fun timerState(): LiveData<Boolean> = isTimerRunning

    fun toggleTimer() {
        if (isTimerRunning.value == true) {
            stopTimer()
        } else {
            startTimer()
        }
    }

    private fun startTimer() {
        isTimerRunning.value = true
    }

    private fun stopTimer() {
        isTimerRunning.value = false
    }

}