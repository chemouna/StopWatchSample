package com.tutorial.stopwatch

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
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
        mainViewModel.toggleTimer(0)

        assertTrue(mainViewModel.timerState().value!!)
    }

    @Test
    fun `toggle stopped timer starts timer`() {
        // start timer
        mainViewModel.toggleTimer(0)
        // stop timer
        mainViewModel.toggleTimer(0)

        assertFalse(mainViewModel.timerState().value!!)
    }
}