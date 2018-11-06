package com.amg.slimadownnow.data

import android.content.Context
import com.amg.slimadownnow.data.weight.WeightRepository

object Injectors {

    fun getWeightRepository(context: Context): WeightRepository {
        return WeightRepository.getInstance(SlimaDb.getInstance(context).weightDao())
    }

}