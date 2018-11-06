
package com.amg.slimadownnow.ui

import android.annotation.SuppressLint
import android.app.Application
import androidx.annotation.VisibleForTesting
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.amg.slimadownnow.data.Injectors
import com.amg.slimadownnow.data.weight.WeightRepository
import com.amg.slimadownnow.ui.weight.tab.WeightTabViewModel


/**
 * @author aaron_goldberg
 *
 * @since 11/06/18
 */
class ViewModelFactory private constructor(
        private val application: Application,
        private val weightRepository: WeightRepository
) : ViewModelProvider.NewInstanceFactory() {

    override fun <T : ViewModel> create(modelClass: Class<T>) =
            with(modelClass) {
                when {
                    isAssignableFrom(WeightTabViewModel::class.java) ->
                        WeightTabViewModel(application, weightRepository)
                    else ->
                        throw IllegalArgumentException("Unknown ViewModel class: ${modelClass.name}")
                }
            } as T

    companion object {

        @SuppressLint("StaticFieldLeak")
        @Volatile private var INSTANCE: ViewModelFactory? = null

        fun getInstance(application: Application) =
                INSTANCE ?: synchronized(ViewModelFactory::class.java) {
                    INSTANCE ?: ViewModelFactory(application,
                            Injectors.getWeightRepository(application.applicationContext))
                            .also { INSTANCE = it }
                }


        @VisibleForTesting
        fun destroyInstance() {
            INSTANCE = null
        }
    }
}
