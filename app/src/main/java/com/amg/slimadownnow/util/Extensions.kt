package com.amg.slimadownnow.util

import androidx.annotation.LayoutRes
import androidx.appcompat.app.AppCompatActivity
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProviders
import com.amg.slimadownnow.ui.ViewModelFactory


/**
 * Allows calls like
 *
 * `viewGroup.inflate(R.layout.foo)`
 */
fun ViewGroup.inflate(@LayoutRes layout: Int, attachToRoot: Boolean = false): View {
    return LayoutInflater.from(context).inflate(layout, this, attachToRoot)
}

/**
 * Allows calls like
 *
 * `supportFragmentManager.inTransaction { add(...) }`
 */
inline fun androidx.fragment.app.FragmentManager.inTransaction(func: androidx.fragment.app.FragmentTransaction.() -> androidx.fragment.app.FragmentTransaction) {
    beginTransaction().func().commit()
}

/**
 * Easy way to get view model in activity's scope
 */
fun <T : ViewModel> AppCompatActivity.obtainViewModel(viewModelClass: Class<T>) =
        ViewModelProviders.of(this, ViewModelFactory.getInstance(application)).get(viewModelClass)

/**
 * The `fragment` is added to the container view with id `frameId`. The operation is
 * performed by the `fragmentManager`.
 */
fun AppCompatActivity.replaceFragment(fragment: androidx.fragment.app.Fragment, frameId: Int) {
    supportFragmentManager.inTransaction {
        replace(frameId, fragment)
    }
}
