package com.amg.slimadownnow.ui.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.amg.slimadownnow.R
import com.amg.slimadownnow.util.inflate
import kotlinx.android.synthetic.main.nav_act.*

/**
 * @author aaron_goldberg
 *
 * @since 10/17/2018
 */
class HomeTabFragment : Fragment() {

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        setupFab()
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return container?.inflate(R.layout.home_tab_frag)
    }

    private fun setupFab() {
        requireActivity().fab_edit.apply {
            hide ()
        }
    }
}