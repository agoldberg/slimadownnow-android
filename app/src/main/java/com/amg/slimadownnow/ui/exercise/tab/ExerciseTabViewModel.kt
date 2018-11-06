package com.amg.slimadownnow.ui.exercise.tab

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import com.amg.slimadownnow.util.SingleLiveEvent

/**
 * @author aaron_goldberg
 *
 * @since 11/06/18
 */
class ExerciseTabViewModel (context: Application) : AndroidViewModel(context) {

    val addExerciseEvent = SingleLiveEvent<Void>()

    fun addExercise() {
        addExerciseEvent.call()
    }
}