package com.example.buyinglistapp

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider


class BuyingListViewModelFactory(private val repository: BuyingListRepository): ViewModelProvider.Factory{

    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(BuyingListViewModel::class.java)){
            @Suppress("UNCHECKED_CAST")
            return BuyingListViewModel(repository) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}