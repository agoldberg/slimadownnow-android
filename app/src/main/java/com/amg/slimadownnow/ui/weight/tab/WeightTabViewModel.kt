package com.amg.slimadownnow.ui.weight.tab

import android.app.Application
import androidx.lifecycle.*
import com.amg.slimadownnow.R
import com.amg.slimadownnow.data.weight.Weight
import com.amg.slimadownnow.data.weight.WeightRepository
import com.amg.slimadownnow.util.SingleLiveEvent

class WeightTabViewModel (
        context: Application, private var weightRepository: WeightRepository) : AndroidViewModel(context) {
    val isWeightRecorded: LiveData<Boolean>
    val sinceYesterday: LiveData<String> = buildSinceYesterday(weightRepository.getTodayWeight(), weightRepository.getYesterdayWeight())
    val newWeightEvent = SingleLiveEvent<Void>()

    init {
        val todayWeight: LiveData<Weight> = weightRepository.getTodayWeight()
        isWeightRecorded = Transformations.map(todayWeight) { it != null }
    }

    fun addWeight() {
        newWeightEvent.call()
    }


    private fun buildSinceYesterday(todayWeight: LiveData<Weight>, yesterdayWeight: LiveData<Weight>): MediatorLiveData<String> {
        return MediatorLiveData<String>().apply {
            var lastTWeight: Weight? = null
            var lastYWeight: Weight? = null
            val bummerString = getApplication<Application>().getString(R.string.weight_bummer)
            val congratsString = getApplication<Application>().getString(R.string.weight_congrats)
            val noChangeString = getApplication<Application>().getString(R.string.weight_no_change)

            fun update() {
                val localTWeight = lastTWeight
                val localYWeight = lastYWeight
                if (localTWeight != null && localYWeight != null) {
                    val delta = localYWeight.pounds - localTWeight.pounds
                    this.value = when {
                        delta < 0 -> String.format(bummerString, -delta)
                        delta > 0 -> String.format(congratsString, delta)
                        else -> noChangeString
                    }
                }
            }

            addSource(todayWeight) {
                lastTWeight = it
                update()
            }
            addSource(yesterdayWeight) {
                lastYWeight = it
                update()
            }
        }
    }
}