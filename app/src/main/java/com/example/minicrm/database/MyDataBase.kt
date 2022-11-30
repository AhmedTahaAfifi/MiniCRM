package com.example.minicrm.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.minicrm.database.dao.MiniCrmDao
import com.example.minicrm.database.model.MiniCrm


@Database(entities = [MiniCrm::class] , version = 2)
abstract class MyDataBase :RoomDatabase(){

    abstract fun miniCrmDao():MiniCrmDao

    companion object{
        private const val DATABASE_NAME = "miniCrm-Database"
        private var myDataBase:MyDataBase?=null
        fun getInstance(context: Context):MyDataBase {
            //Singleton pattern
            if (myDataBase==null) {
                myDataBase = Room.databaseBuilder(
                    context, MyDataBase::class.java, DATABASE_NAME)
                    .fallbackToDestructiveMigration()
                    .allowMainThreadQueries()
                    .build()
            }
            return myDataBase!!
        }
    }
}