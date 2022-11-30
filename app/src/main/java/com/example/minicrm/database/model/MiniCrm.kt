package com.example.minicrm.database.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey


@Entity
data class MiniCrm(
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo
    val id: Int? = null,
    @ColumnInfo
    val name:String? = null,
    @ColumnInfo
    val phoneNumber: String? = null,
    @ColumnInfo
    val email:String? = null,


        )

