package com.amg.slimadownnow.ui.exercise.addedit

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import com.amg.slimadownnow.data.weight.WeightRepository
import com.amg.slimadownnow.util.SingleLiveEvent

/**
 * @author aaron_goldberg
 *
 * @since 11/06/18
 */
class ExerciseAddEditViewModel (
        context: Application) : AndroidViewModel(context) {

    val saveExerciseEvent = SingleLiveEvent<Void>()

    fun saveExercise() {
        saveExerciseEvent.call()
    }
}