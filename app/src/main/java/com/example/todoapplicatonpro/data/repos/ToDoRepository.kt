package com.example.todoapplicatonpro.data.repos

import com.example.todoapplicatonpro.data.datasources.ToDoDatasource
import com.example.todoapplicatonpro.data.entity.ToDo

class ToDoRepository(
    var toDoDatasource: ToDoDatasource
) {

    suspend fun save(name : String) {
        toDoDatasource.saveToDo(name)
    }

    suspend fun updateToDo(id : Int,name : String) = toDoDatasource.updateToDo(id,name)

    suspend fun deleteToDo(id : Int) = toDoDatasource.deleteToDo(id)

    suspend fun getToDos() : List<ToDo> = toDoDatasource.getToDos()

    suspend fun search(searchText : String) : List<ToDo> = toDoDatasource.search(searchText)
}