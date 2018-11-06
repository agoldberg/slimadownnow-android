package com.amg.slimadownnow.weight

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.room.Room
import androidx.test.InstrumentationRegistry
import androidx.test.ext.junit.runners.AndroidJUnit4
import com.amg.slimadownnow.data.Converters
import com.amg.slimadownnow.data.SlimaDb
import com.amg.slimadownnow.data.weight.WeightDao
import com.amg.slimadownnow.util.getValue
import com.amg.slimadownnow.util.testWeights

import org.junit.After
import org.junit.Assert.*
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import java.time.LocalDate
import java.time.LocalTime
import java.time.OffsetDateTime

/**
 * @author aaron_goldberg
 *
 * @since 10/19/2018
 */
@RunWith(AndroidJUnit4::class)
class  WeightDaoTest {
    private lateinit var database: SlimaDb
    private lateinit var weightDao: WeightDao

    @get:Rule
    var instantTaskExecutorRule = InstantTaskExecutorRule()

    @Before
    fun createDb() {
        val context = InstrumentationRegistry.getTargetContext()
        database = Room.inMemoryDatabaseBuilder(context, SlimaDb::class.java).build()
        weightDao = database.weightDao()

        // Insert plants in non-alphabetical order to test that results are sorted by name
        weightDao.addWeight(testWeights[0])
        weightDao.addWeight(testWeights[1])
    }

    @After
    fun closeDb() {
        database.close()
    }

    @Test
    fun testGetTodayWeight() {
        val today = LocalDate.now()
        val zoneOffset = OffsetDateTime.now().offset

        val midnightYesterday = OffsetDateTime.of(
                today,
                LocalTime.MIDNIGHT,
                zoneOffset)

        val midnightToday = OffsetDateTime.of(
                today.plusDays(1),
                LocalTime.MIDNIGHT,
                zoneOffset)

        val todaysWeight = weightDao.getWeightInRange(
                Converters.fromOffsetDateTime(midnightYesterday),
                Converters.fromOffsetDateTime(midnightToday))

        assertEquals(testWeights[0], getValue(todaysWeight))
    }

    @Test
    fun testGetYesterdayWeight() {
        val today = LocalDate.now()
        val zoneOffset = OffsetDateTime.now().offset

        val midnightYesterday = OffsetDateTime.of(
                today,
                LocalTime.MIDNIGHT,
                zoneOffset)

        val midnightTwoYesterdays = OffsetDateTime.of(
                today.minusDays(1),
                LocalTime.MIDNIGHT,
                zoneOffset)

        val yesterdaysWeight = weightDao.getWeightInRange(
                Converters.fromOffsetDateTime(midnightTwoYesterdays),
                Converters.fromOffsetDateTime(midnightYesterday))

        assertEquals(testWeights[1], getValue(yesterdaysWeight))
    }

    @Test
    fun testGetTomorrowWeight() {
        val today = LocalDate.now()
        val zoneOffset = OffsetDateTime.now().offset

        val midnightToday = OffsetDateTime.of(
                today.plusDays(1),
                LocalTime.MIDNIGHT,
                zoneOffset)

        val midnightTomorrow = OffsetDateTime.of(
                today.plusDays(2),
                LocalTime.MIDNIGHT,
                zoneOffset)

        val tomorrowsWeight = weightDao.getWeightInRange(
                Converters.fromOffsetDateTime(midnightToday),
                Converters.fromOffsetDateTime(midnightTomorrow))

        assertNull(getValue(tomorrowsWeight))
    }

    @Test
    fun testGetHistory() {
        val weightHistory = getValue(weightDao.getWeightHistory())
        assertEquals(weightHistory.size, 2)
        assertEquals(weightHistory[0], testWeights[0])  // today
        assertEquals(weightHistory[1], testWeights[1])  // yesterday
    }


}