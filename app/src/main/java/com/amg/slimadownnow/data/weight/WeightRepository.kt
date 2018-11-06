package com.amg.slimadownnow.data.weight

import androidx.lifecycle.LiveData
import com.amg.slimadownnow.data.Converters
import com.amg.slimadownnow.util.runOnIoThread
import java.time.LocalDate
import java.time.LocalTime
import java.time.OffsetDateTime

/**
 * @author aaron_goldberg
 *
 * since 10/19/2018
 */
class WeightRepository private constructor(private val weightDao: WeightDao) {

    fun addWeight(pounds: Int) = runOnIoThread { weightDao.addWeight(Weight(pounds = pounds))}

    fun getWeightHistory() = weightDao.getWeightHistory()

    fun getTodayWeight(): LiveData<Weight> {
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
        return weightDao.getWeightInRange(
                Converters.fromOffsetDateTime(midnightYesterday),
                Converters.fromOffsetDateTime(midnightToday))
    }

    fun getYesterdayWeight(): LiveData<Weight> {
        val today = LocalDate.now()
        val zoneOffset = OffsetDateTime.now().offset

        val midnightDayBeforeYesterday = OffsetDateTime.of(
                today.minusDays(1),
                LocalTime.MIDNIGHT,
                zoneOffset)

        val midnightYesterday = OffsetDateTime.of(
                today,
                LocalTime.MIDNIGHT,
                zoneOffset)
        return weightDao.getWeightInRange(
                Converters.fromOffsetDateTime(midnightDayBeforeYesterday),
                Converters.fromOffsetDateTime(midnightYesterday))
    }

    companion object {
        @Volatile private var instance: WeightRepository? = null

        fun getInstance(weightDao: WeightDao) =
                instance ?: synchronized(this) {
                    instance ?: WeightRepository(weightDao).also { instance = it }
                }
    }
}