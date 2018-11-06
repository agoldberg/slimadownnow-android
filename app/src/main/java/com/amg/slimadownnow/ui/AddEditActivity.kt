package com.amg.slimadownnow.ui

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import com.amg.slimadownnow.R
import com.amg.slimadownnow.ui.exercise.addedit.ExerciseAddEditFragment
import com.amg.slimadownnow.ui.exercise.addedit.ExerciseAddEditViewModel
import com.amg.slimadownnow.ui.food.addedit.FoodAddEditFragment
import com.amg.slimadownnow.ui.food.addedit.FoodAddEditViewModel
import com.amg.slimadownnow.ui.weight.addedit.WeightAddEditFragment
import com.amg.slimadownnow.ui.weight.addedit.WeightAddEditViewModel
import com.amg.slimadownnow.util.obtainViewModel
import com.amg.slimadownnow.util.replaceFragment
import com.google.android.material.snackbar.Snackbar

/**
 * @author aaron_goldberg
 *
 * @since 10/18/2018
 */
class AddEditActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.addedit_act)
        setupObservers()
        replaceFragment(loadFragment(), R.id.fragment_container)
    }

    private fun setupObservers() {
        obtainWeightAddEditViewModel().apply {
            saveWeightEvent.observe(this@AddEditActivity, Observer<Void> {
                this@AddEditActivity.onSaveEvent(WEIGHT)
            })
        }
        obtainFoodAddEditViewModel().apply {
            saveFoodEvent.observe(this@AddEditActivity, Observer<Void> {
                this@AddEditActivity.onSaveEvent(AddEditActivity.FOOD)
            })
        }
        obtainExerciseAddEditViewModel().apply {
            saveExerciseEvent.observe(this@AddEditActivity, Observer<Void> {
                this@AddEditActivity.onSaveEvent(AddEditActivity.EXERCISE)
            })
        }
    }

    private fun onSaveEvent(type: String) {
        Snackbar.make(
                findViewById(R.id.coordinator_layout),
                "YO YO YO SAVE THIS! ${type}",
                Snackbar.LENGTH_SHORT
        ).show()

    }

    private fun loadFragment(): Fragment {
        val type = intent.getStringExtra(ADD_EDIT_TYPE)
        return supportFragmentManager.findFragmentById(R.id.fragment_container) ?:
        when (type){
            WEIGHT -> WeightAddEditFragment()
            FOOD -> FoodAddEditFragment()
            EXERCISE -> ExerciseAddEditFragment()
            else -> throw IllegalArgumentException("Unknown ADD_EDIT_TYPE: ${type}")
        }
    }

    companion object {
        const val ADD_EDIT_TYPE = "ADD_EDIT_TYPE"
        const val WEIGHT = "WEIGHT"
        const val FOOD = "FOOD"
        const val EXERCISE = "EXERCISE"
    }

    fun obtainWeightAddEditViewModel(): WeightAddEditViewModel = obtainViewModel(WeightAddEditViewModel::class.java)
    fun obtainFoodAddEditViewModel(): FoodAddEditViewModel = obtainViewModel(FoodAddEditViewModel::class.java)
    fun obtainExerciseAddEditViewModel(): ExerciseAddEditViewModel = obtainViewModel(ExerciseAddEditViewModel::class.java)

}