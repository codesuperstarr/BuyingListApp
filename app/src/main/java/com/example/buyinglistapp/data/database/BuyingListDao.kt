package com.example.buyinglistapp.data.database


import androidx.room.*
import com.example.buyinglistapp.data.model.BuyingItems
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