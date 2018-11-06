package com.amg.slimadownnow.data.weight

import androidx.room.Entity
import androidx.room.PrimaryKey
import java.time.OffsetDateTime
import java.util.*

@Entity
data class Weight(
        @PrimaryKey
        var id: String = UUID.randomUUID().toString(),
        val pounds: Int = 0,
        val created: OffsetDateTime = OffsetDateTime.now())