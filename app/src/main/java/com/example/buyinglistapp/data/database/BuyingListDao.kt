package com.example.buyinglistapp.data.database


import androidx.lifecycle.LiveData
import androidx.room.*
import com.example.buyinglistapp.data.model.BuyingItems
import kotlinx.coroutines.flow.Flow

@Dao
interface BuyingListDao {

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insert(items: BuyingItems)

    @Update(onConflict = OnConflictStrategy.REPLACE)
    suspend fun update()

    @Query("DELETE FROM buying_list_table")
    suspend fun deleteAll()

    @Query("SELECT * FROM buying_list_table ORDER BY name ASC")
    fun getAllAlphabetizedWords(): LiveData<List<BuyingItems>>

    @Query("SELECT * FROM buying_list_table ORDER BY id DESC")
    fun getAllItems() :LiveData<List<BuyingItems>>

    @Query("SELECT * FROM buying_list_table ORDER BY id DESC LIMIT 1")
    fun getOneItem(): BuyingItems?

    @Query("SELECT * FROM buying_list_table ORDER BY id DESC")
    fun getRawList() :List<BuyingItems>

    @Query("SELECT * FROM buying_list_table WHERE id=:id ")
    fun getItemById(id: Int) : BuyingItems
}