package com.example.buyinglistapp.data.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "buying_list_table")
data class BuyingItems(

    @ColumnInfo(name = "name")
    val name: String,
    @PrimaryKey(autoGenerate = true)
    val id: Int? = null
) {

}