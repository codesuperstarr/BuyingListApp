package com.example.buyinglistapp

import androidx.annotation.WorkerThread
import androidx.lifecycle.LiveData
import kotlinx.coroutines.flow.Flow


class BuyingListRepository(private val buyingListDao: BuyingListDao){

    val allBuyingListItems: Flow<List<BuyingItems>> = buyingListDao.getAllAlphabetizedWords()


    @Suppress("RedundantSuspendModifier")
    @WorkerThread
    suspend fun insert(items: BuyingItems){
        buyingListDao.insert(items)
    }
}

