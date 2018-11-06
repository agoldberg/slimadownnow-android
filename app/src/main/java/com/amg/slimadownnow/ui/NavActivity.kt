package com.amg.slimadownnow.ui


import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.NavigationUI
import com.amg.slimadownnow.R
import com.amg.slimadownnow.ui.exercise.tab.ExerciseTabViewModel
import com.amg.slimadownnow.ui.food.tab.FoodTabViewModel
import com.amg.slimadownnow.ui.weight.tab.WeightTabViewModel
import com.amg.slimadownnow.util.obtainViewModel
import com.google.android.material.bottomnavigation.BottomNavigationView

/**
 * @author aaron_goldberg
 *
 * @since 10/17/2018
 */
class NavActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.nav_act)
        setupVMs()
        setupBottomNav()
    }

    private fun setupVMs() {
        obtainWeightTabViewModel().apply {
            newWeightEvent.observe(this@NavActivity, Observer<Void> {
                this@NavActivity.addNew(AddEditActivity.WEIGHT)
            })
        }
        obtainFoodTabViewModel().apply {
            newFoodEvent.observe(this@NavActivity, Observer<Void> {
                this@NavActivity.addNew(AddEditActivity.FOOD)
            })
        }
        obtainExerciseTabViewModel().apply {
            newExerciseEvent.observe(this@NavActivity, Observer<Void> {
                this@NavActivity.addNew(AddEditActivity.EXERCISE)
            })
        }
    }

    private fun setupBottomNav() {
        val host: NavHostFragment = supportFragmentManager.findFragmentById(R.id.fragment_container) as NavHostFragment? ?: return

        findViewById<BottomNavigationView>(R.id.navigation)?.let { bottomNavView ->
            NavigationUI.setupWithNavController(bottomNavView, host.navController)
        }
    }

    private fun addNew(type: String) {
        val intent = Intent(this, AddEditActivity::class.java).apply {
            putExtra(AddEditActivity.ADD_EDIT_TYPE, type)
        }
        startActivity(intent)
    }

    fun obtainWeightTabViewModel(): WeightTabViewModel = obtainViewModel(WeightTabViewModel::class.java)
    fun obtainFoodTabViewModel(): FoodTabViewModel = obtainViewModel(FoodTabViewModel::class.java)
    fun obtainExerciseTabViewModel(): ExerciseTabViewModel = obtainViewModel(ExerciseTabViewModel::class.java)

}
