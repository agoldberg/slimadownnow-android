package com.amg.slimadownnow.ui

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.amg.slimadownnow.R
import com.amg.slimadownnow.ui.exercise.addedit.ExerciseAddEditFragment
import com.amg.slimadownnow.ui.food.addedit.FoodAddEditFragment
import com.amg.slimadownnow.ui.weight.addedit.WeightAddEditFragment
import com.amg.slimadownnow.util.replaceFragment

/**
 * @author aaron_goldberg
 *
 * @since 10/18/2018
 */
class AddEditActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.addedit_act)

        replaceFragment(loadFragment(), R.id.fragment_container)
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

}