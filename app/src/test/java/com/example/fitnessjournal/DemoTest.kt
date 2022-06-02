package com.example.fitnessjournal

import io.mockk.confirmVerified
import io.mockk.every
import io.mockk.mockk
import io.mockk.verify
import org.junit.After
import org.junit.Assert.assertEquals
import org.junit.Assert.assertFalse
import org.junit.Assert.assertNull
import org.junit.Assert.assertTrue
import org.junit.Before
import org.junit.Test
import kotlin.random.Random

class Calculator(
    private val random: Random = Random
) {
    fun addTwo(value: Int): Int =
        value + 2

    fun addTwoToRandomNumber(): Int{
        return random.nextInt() + 2
    }

    fun addValueToRandomNumber(value: Int): Int{
        return random.nextInt() + value
    }
}


class CalculatorTest {
    //    private val calculator = Calculator()
    private lateinit var calculator: Calculator
    private val random: Random = mockk()

    @Before
    fun setup(){
        calculator = Calculator(random = random)
    }

    @After
    fun teardown(){
        confirmVerified(random)
    }

    @Test
    fun `Test adding 2 to a random number`(){
        every { random.nextInt()} returns 1
        assertEquals(3, calculator.addTwoToRandomNumber())

        verify { random.nextInt() }

        // Can pass things to verify. For example:
        verify(atMost = 2) {random.nextInt() }
    }

    // Standard way of naming tests
    @Test
    fun testAddTwo(){
        val result = calculator.addTwo(2)
        val expected = 4

        assertEquals(expected, result)
        assertTrue(true)
        assertFalse(false)
        assertNull(null)

        val params = listOf(
            // Pair(expected, given)
            Pair(4, 2),
            Pair(2, 0),
            Pair(-2, -4),
            Pair(5, 3),
            Pair(4, 2)
        )
        params.map {(expected, given) ->
            assertEquals(expected, calculator.addTwo(given))
        }
    }

    // In Kotlin you can do
    @Test
    fun `test that something works while writing it as a sentence`(){

    }
}

class DemoTest {
}
