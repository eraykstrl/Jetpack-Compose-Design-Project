package com.example.todoapplicatonpro.room

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.todoapplicatonpro.data.entity.ToDo

@Database(entities = [ToDo::class], version = 3)
abstract class ToDosDatabase : RoomDatabase()   {

    abstract fun toDos() : ToDoDao

}