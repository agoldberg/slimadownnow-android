package com.amg.slimadownnow.ui.weight.addedit

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.amg.slimadownnow.R
import com.amg.slimadownnow.util.inflate
import kotlinx.android.synthetic.main.activity_main.*

/**
 * @author aaron_goldberg
 *
 * @since 11/06/18
 */
class WeightAddEditFragment : Fragment() {
    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        setupFab()
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return container?.inflate(R.layout.frag_tab_home)
    }

    private fun setupFab() {
        requireActivity().fab_edit.apply {
            hide ()
        }
    }
}