package com.example.buyinglistapp

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(entities = arrayOf(BuyingItems::class), version = 1)
public abstract class BuyingListDatabase: RoomDatabase() {

    abstract fun buyingListDao(): BuyingListDao()

    companion object {
        // Singleton prevents multiple instances of database opening at the
        // same time.
        @Volatile
        private var INSTANCE: BuyingListDatabase? = null

        fun getDatabase(context: Context): BuyingListDatabase {
            // if the INSTANCE is not null, then return it,
            // if it is, then create the database
            return INSTANCE ?: synchronized(this) {
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    BuyingListDatabase::class.java,
                    "buyingList_database"
                ).build()
                INSTANCE = instance
                // return instance
                instance
            }
        }
    }
}