package com.amg.slimadownnow.util

import com.amg.slimadownnow.data.weight.Weight
import java.time.OffsetDateTime

/**
 * [Weight] objects used for tests.
 */
val testWeights = arrayListOf(
        Weight(pounds = 250),
        Weight(pounds = 200, created = OffsetDateTime.now().minusDays(1)),
        Weight(pounds = 150, created = OffsetDateTime.now().minusDays(2))

)