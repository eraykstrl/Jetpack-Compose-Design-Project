package com.example.todoapplicatonpro.data.datasources

import android.util.Log
import com.example.todoapplicatonpro.data.entity.ToDo
import com.example.todoapplicatonpro.room.ToDoDao
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class ToDoDatasource(
    var toDosDao: ToDoDao
) {

    suspend fun saveToDo(name : String) {
        toDosDao.saveToDo(ToDo(0,name))
    }

    suspend fun updateToDo(id : Int,name : String) {
        toDosDao.updateToDo(id,name)
        Log.e("Update Screen","Şu an datasourcedayiz id : $id ve name $name")
    }

    suspend fun deleteToDo(id : Int) {
        toDosDao.deleteToDo(id)
    }

    suspend fun getToDos() : List<ToDo> = withContext(Dispatchers.IO) {
        return@withContext toDosDao.getToDos()
    }

    suspend fun search(searchText : String) : List<ToDo> = withContext(Dispatchers.IO) {
        return@withContext toDosDao.search(searchText)
    }



}