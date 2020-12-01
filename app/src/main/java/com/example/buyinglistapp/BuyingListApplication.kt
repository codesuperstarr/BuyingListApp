package com.example.buyinglistapp

import android.app.Application
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.SupervisorJob

class BuyingListApplication :Application(){

    val applicationScope = CoroutineScope(SupervisorJob())

    val database by lazy { BuyingListDatabase.getDatabase(this, applicationScope) }
    val repository by lazy { BuyingListRepository(database.buyingListDao()) }
}