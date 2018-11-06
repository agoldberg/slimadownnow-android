package com.amg.slimadownnow.ui.exercise.addedit

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.amg.slimadownnow.R
import com.amg.slimadownnow.util.inflate
import kotlinx.android.synthetic.main.addedit_act.*

/**
 * @author aaron_goldberg
 *
 * @since 11/06/18
 */
class ExerciseAddEditFragment : Fragment() {
    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        setupFab()
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return container?.inflate(R.layout.exercise_addedit_frag)
    }

    private fun setupFab() {
        requireActivity().confirm.apply {
            show ()
        }
    }
}