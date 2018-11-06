package com.amg.slimadownnow.ui.food.tab

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import com.amg.slimadownnow.util.SingleLiveEvent

/**
 * @author aaron_goldberg
 *
 * @since 11/06/18
 */
class FoodTabViewModel (context: Application) : AndroidViewModel(context) {

    val addFoodEvent = SingleLiveEvent<Void>()

    fun addFood() {
        addFoodEvent.call()
    }
}