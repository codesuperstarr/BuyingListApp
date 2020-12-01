package com.example.buyinglistapp

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.sqlite.db.SupportSQLiteDatabase
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.launch
import java.time.chrono.HijrahChronology.INSTANCE

@Database(entities = arrayOf(BuyingItems::class), version = 1, exportSchema = false)
abstract class BuyingListDatabase : RoomDatabase() {

    abstract fun buyingListDao(): BuyingListDao

    private class WordDatabaseCallback(
        private val scope: CoroutineScope
    ) : RoomDatabase.Callback() {

        override fun onCreate(db: SupportSQLiteDatabase) {
            super.onCreate(db)
            INSTANCE?.let { database ->
                scope.launch {
                    var buyingListDao = database.buyingListDao()

                    // Delete all content here.
                    buyingListDao.deleteAll()

                    // Add sample words.
                    var word = BuyingItems("Hello")
                   buyingListDao.insert(word)
                    word = BuyingItems("World!")
                    buyingListDao.insert(word)

                    // TODO: Add your own words!
                    word =BuyingItems("TODO!")
                    buyingListDao.insert(word)
                }
            }
        }
    }

    companion object {
        @Volatile
        private var INSTANCE: BuyingListDatabase? = null

        fun getDatabase(
            context: Context,
            scope: CoroutineScope
        ): BuyingListDatabase {
            // if the INSTANCE is not null, then return it,
            // if it is, then create the database
            return INSTANCE ?: synchronized(this) {
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    BuyingListDatabase::class.java,
                    "word_database"
                )
                    .addCallback(WordDatabaseCallback(scope))
                    .build()
                INSTANCE = instance
                // return instance
                instance
            }
        }
    }
}