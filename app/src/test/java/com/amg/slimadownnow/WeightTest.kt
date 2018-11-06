package com.amg.slimadownnow

import com.amg.slimadownnow.data.weight.Weight
import org.junit.Test

import org.junit.Assert.*
import org.junit.Before
import java.time.OffsetDateTime

/**
 * @author aaron_goldberg
 *
 * @since 10/19/2018
 */
class WeightTest {
    private lateinit var weight: Weight

    @Before fun setUp() {
        weight = Weight(pounds = 200)

    }

    @Test
    fun test_default_values() {
        val now = OffsetDateTime.now()
        assertEquals(200, weight.pounds)
        assertEquals(now.year, weight.created.year)
        assertEquals(now.month, weight.created.month)
        assertEquals(now.dayOfMonth, weight.created.dayOfMonth)
        assertEquals(now.hour, weight.created.hour)
        assertEquals(now.minute, weight.created.minute)
    }
}
