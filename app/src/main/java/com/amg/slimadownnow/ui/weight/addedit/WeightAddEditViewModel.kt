package com.amg.slimadownnow.ui.weight.addedit

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import com.amg.slimadownnow.data.weight.WeightRepository
import com.amg.slimadownnow.util.SingleLiveEvent

/**
 * @author aaron_goldberg
 *
 * @since 11/06/18
 */
class WeightAddEditViewModel (
        context: Application,
        private var weightRepository: WeightRepository) : AndroidViewModel(context) {

    val saveWeightEvent = SingleLiveEvent<Void>()

    fun saveWeight() {
        saveWeightEvent.call()
    }
}