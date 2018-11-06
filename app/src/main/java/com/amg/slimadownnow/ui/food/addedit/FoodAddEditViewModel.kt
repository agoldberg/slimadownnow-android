package com.amg.slimadownnow.ui.food.addedit

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import com.amg.slimadownnow.data.weight.WeightRepository
import com.amg.slimadownnow.util.SingleLiveEvent

/**
 * @author aaron_goldberg
 *
 * @since 11/06/18
 */
class FoodAddEditViewModel (
        context: Application) : AndroidViewModel(context) {

    val saveFoodEvent = SingleLiveEvent<Void>()

    fun saveFood() {
        saveFoodEvent.call()
    }
}