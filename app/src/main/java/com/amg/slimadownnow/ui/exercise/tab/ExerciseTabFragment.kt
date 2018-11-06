package com.amg.slimadownnow.ui.exercise.tab

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import com.amg.slimadownnow.R
import com.amg.slimadownnow.databinding.ExerciseTabFragBinding
import com.amg.slimadownnow.ui.NavActivity
import kotlinx.android.synthetic.main.nav_act.*

/**
 * @author aaron_goldberg
 *
 * @since 10/17/2018
 */
class ExerciseTabFragment : Fragment() {

    private lateinit var viewDataBinding: ExerciseTabFragBinding

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        setupFab()
    }
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        viewDataBinding = DataBindingUtil.inflate<ExerciseTabFragBinding>(
                inflater, R.layout.exercise_tab_frag, container, false).apply {
            viewModel = (activity as NavActivity).obtainExerciseTabViewModel()
            setLifecycleOwner(this@ExerciseTabFragment)
        }

        return viewDataBinding.root
    }

    fun setupFab() {
        requireActivity().fab_edit.apply {
            show ()
            setOnClickListener {
                viewDataBinding.viewModel?.addExercise()
            }
        }
    }
}