package com.amg.slimadownnow.ui

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.amg.slimadownnow.R
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
        return supportFragmentManager.findFragmentById(R.id.fragment_container) ?: WeightAddEditFragment()
    }

    companion object {
        const val ADD_EDIT_TYPE = "ADD_EDIT_TYPE"
        const val WEIGHT = "WEIGHT"
    }

}