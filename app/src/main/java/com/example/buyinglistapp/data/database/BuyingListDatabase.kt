package com.example.buyinglistapp.data.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.sqlite.db.SupportSQLiteDatabase
import com.example.buyinglistapp.data.model.BuyingItems
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.launch

@Database(entities = arrayOf(BuyingItems::class), version = 1, exportSchema = false)
abstract class BuyingListDatabase : RoomDatabase() {

    abstract fun buyingListDao(): BuyingListDao


companion object{

    @Volatile
    private var INSTANCE: BuyingListDatabase? = null

    fun getInstance(context: Context) : BuyingListDatabase{
        synchronized(this){
            var instance = INSTANCE
            if (instance == null){
                instance = Room.databaseBuilder(context.applicationContext
                    ,BuyingListDatabase::class.java,"shopping_items_database")
                    .fallbackToDestructiveMigration()
                    .build()
                INSTANCE = instance
            }
            return instance
        }
    }

}
}