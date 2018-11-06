package com.amg.slimadownnow.ui.food.tab

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import com.amg.slimadownnow.util.SingleLiveEvent

class FoodTabViewModel (context: Application) : AndroidViewModel(context) {

    val newFoodEvent = SingleLiveEvent<Void>()

    fun addFood() {
        newFoodEvent.call()
    }
}