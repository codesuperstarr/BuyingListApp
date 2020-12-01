package com.example.buyinglistapp


import androidx.room.*
import kotlinx.coroutines.flow.Flow

@Dao
interface BuyingListDao {
    @Query("SELECT * FROM buying_list_table ORDER BY name ASC")
    fun getAllAlphabetizedWords(): Flow<List<BuyingItems>>

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insert(items: BuyingItems)

    @Query("DELETE FROM buying_list_table")
    suspend fun deleteAll()
}