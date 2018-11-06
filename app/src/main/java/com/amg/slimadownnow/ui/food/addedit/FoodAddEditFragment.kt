package com.amg.slimadownnow.ui.food.addedit

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.amg.slimadownnow.R
import com.amg.slimadownnow.ui.AddEditActivity
import com.amg.slimadownnow.util.inflate
import kotlinx.android.synthetic.main.addedit_act.*

/**
 * @author aaron_goldberg
 *
 * @since 11/06/18
 */
class FoodAddEditFragment : Fragment() {
    private lateinit var viewModel: FoodAddEditViewModel

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        setupFab()
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        viewModel = (activity as AddEditActivity).obtainFoodAddEditViewModel()
        return container?.inflate(R.layout.food_addedit_frag)
    }

    private fun setupFab() {
        requireActivity().confirm.apply {
            show ()
            setOnClickListener {
                viewModel.saveFood()
            }
        }
    }
}