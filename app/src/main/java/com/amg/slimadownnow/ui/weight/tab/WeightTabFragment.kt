package com.amg.slimadownnow.ui.weight.tab

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import com.amg.slimadownnow.R
import com.amg.slimadownnow.databinding.FragTabWeightBinding
import com.amg.slimadownnow.ui.NavActivity
import kotlinx.android.synthetic.main.activity_main.*


/**
 * @author aaron_goldberg
 *
 * @since 10/17/2018
 */
class WeightTabFragment : Fragment() {

    private lateinit var viewDataBinding: FragTabWeightBinding

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        setupFab()
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        viewDataBinding = DataBindingUtil.inflate<FragTabWeightBinding>(
                inflater, R.layout.frag_tab_weight, container, false).apply {
            viewModel = (activity as NavActivity).obtainWeightTabViewModel()
            setLifecycleOwner(this@WeightTabFragment)
        }

        return viewDataBinding.root
    }

     private fun setupFab() {
         requireActivity().fab_edit.apply {
             show ()
             setOnClickListener {
                 viewDataBinding.viewModel?.addWeight()
             }
         }
    }
}