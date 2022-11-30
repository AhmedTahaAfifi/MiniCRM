package com.example.minicrm.database.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update
import com.example.minicrm.database.model.MiniCrm


@Dao
interface MiniCrmDao {

    @Insert
    fun addCustomers(crm: MiniCrm)

    @Update
    fun updateCustomer(crm: MiniCrm)

    @Delete
    fun deleteCustomer(crm: MiniCrm)

    @Query("select * from MiniCrm")
    fun gatAllCustomer():List<MiniCrm>
}