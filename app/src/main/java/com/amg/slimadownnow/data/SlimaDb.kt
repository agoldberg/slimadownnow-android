package com.amg.slimadownnow.data

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.amg.slimadownnow.data.weight.Weight
import com.amg.slimadownnow.data.weight.WeightDao

@Database(entities = [Weight::class], version = 1, exportSchema  = false)
@TypeConverters(Converters::class)
abstract class SlimaDb : RoomDatabase() {
    abstract fun weightDao(): WeightDao

    companion object {
        @Volatile private var INSTANCE: SlimaDb? = null

        fun getInstance(context: Context): SlimaDb =
                INSTANCE ?: synchronized(this) {
                    INSTANCE ?: buildDatabase(context).also { INSTANCE = it }
                }

        private fun buildDatabase(context: Context) =
                Room.databaseBuilder(context.applicationContext, SlimaDb::class.java, "slima.db").
                        fallbackToDestructiveMigration().
                        build()
    }


}