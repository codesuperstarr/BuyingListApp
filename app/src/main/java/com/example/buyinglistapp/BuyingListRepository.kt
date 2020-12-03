package com.example.buyinglistapp

import androidx.annotation.WorkerThread
import com.example.buyinglistapp.data.database.BuyingListDao
import com.example.buyinglistapp.data.model.BuyingItems
import kotlinx.coroutines.flow.Flow


class BuyingListRepository(private val buyingListDao: BuyingListDao){

    val allBuyingListItems: Flow<List<BuyingItems>> = buyingListDao.getAllAlphabetizedWords()


    @Suppress("RedundantSuspendModifier")
    @WorkerThread
    suspend fun insert(items: BuyingItems){
        buyingListDao.insert(items)
    }
}

