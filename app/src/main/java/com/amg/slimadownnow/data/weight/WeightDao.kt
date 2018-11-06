package com.amg.slimadownnow.data.weight

import androidx.lifecycle.LiveData
import androidx.room.*

/**
 * @author aaron_goldberg
 *
 * @since 10/19/2018
 */
@Dao
interface WeightDao {

    @Insert
    fun addWeight(weight: Weight)

    @Query("SELECT * FROM weight WHERE created BETWEEN datetime(:day_start) AND datetime(:day_end) ORDER BY created DESC LIMIT 1")
    fun getWeightInRange(day_start: String?, day_end: String?): LiveData<Weight>

    @Query("SELECT * FROM weight ORDER BY created DESC")
    fun getWeightHistory(): LiveData<List<Weight>>
}


