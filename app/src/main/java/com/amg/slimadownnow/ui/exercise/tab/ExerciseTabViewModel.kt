package com.amg.slimadownnow.ui.exercise.tab

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import com.amg.slimadownnow.util.SingleLiveEvent

class ExerciseTabViewModel (context: Application) : AndroidViewModel(context) {

    val newExerciseEvent = SingleLiveEvent<Void>()

    fun addExercise() {
        newExerciseEvent.call()
    }
}