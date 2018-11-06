package com.amg.slimadownnow.ui

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.amg.slimadownnow.R

/**
 * @author aaron_goldberg
 *
 * @since 10/18/2018
 */
class AddEditActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add)
    }

    companion object {
        const val ADD_EDIT_TYPE = "ADD_EDIT_TYPE"
        const val WEIGHT = "WEIGHT"
    }

}