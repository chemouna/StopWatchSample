package com.tutorial.stopwatch

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import junit.framework.Assert.assertEquals
import junit.framework.Assert.assertFalse
import junit.framework.Assert.assertTrue
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import org.junit.runners.JUnit4

@RunWith(JUnit4::class)
class MainViewModelTest {

    private lateinit var mainViewModel: MainViewModel

    @get:Rule var instantTaskExecutorRule = InstantTaskExecutorRule()

    @Before
    fun setUp() {
        mainViewModel = MainViewModel()
    }

    @Test
    fun `toggle running timer stops timer`() {
        // timer starts as not running
        // start timer
        mainViewModel.toggleTimer(10)

        assertTrue(mainViewModel.timerState().value!!)
    }

    @Test
    fun `toggle stopped timer starts timer`() {
        // start timer
        mainViewModel.toggleTimer(12)
        // stop timer
        mainViewModel.toggleTimer(25)

        assertFalse(mainViewModel.timerState().value!!)
    }

    @Test
    fun `reset timer stops timer`() {
        // start timer
        mainViewModel.toggleTimer(12)

        val elapsedTime: Long = 25
        mainViewModel.resetTimer(elapsedTime)

        // stops timer
        assertFalse(mainViewModel.timerState().value!!)
        // sets base to correct value
        assertEquals(elapsedTime, mainViewModel.timerBase().value)
    }

    @Test
    fun `Base time is set correctly`() { // TODO: rename ?
        mainViewModel.toggleTimer(0)

        mainViewModel.toggleTimer(6) // so 6s

        mainViewModel.toggleTimer(10) // start again after 4 seconds (so we want base to be 4)

        assertEquals(4, mainViewModel.timerBase().value!!)
    }
    
}