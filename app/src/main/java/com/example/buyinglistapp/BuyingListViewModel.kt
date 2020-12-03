package com.example.buyinglistapp

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import androidx.lifecycle.viewModelScope
import com.example.buyinglistapp.data.model.BuyingItems
import kotlinx.coroutines.launch

class BuyingListViewModel(private val repository: BuyingListRepository): ViewModel() {

    val allBuyingListItems: LiveData<List<BuyingItems>> = repository.allBuyingListItems.asLiveData()

    fun insert(items: BuyingItems) = viewModelScope.launch {
        repository.insert(items)
    }
}