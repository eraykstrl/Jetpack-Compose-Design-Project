package com.example.todoapplicatonpro.room


import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.example.todoapplicatonpro.data.entity.ToDo


@Dao
interface ToDoDao {

    @Query("SELECT * FROM to_dos")
    suspend fun getToDos() : List<ToDo>

    @Insert
    suspend fun saveToDo(toDo: ToDo)

    @Query("UPDATE to_dos SET name = :name WHERE id = :id")
    suspend fun updateToDo(id : Int,name : String)

    @Query("DELETE FROM to_dos WHERE id = :id")
    suspend fun deleteToDo(id : Int)

    @Query("SELECT * FROM to_dos WHERE name LIKE '%' || :searchText || '%' ")
    suspend fun search(searchText : String) : List<ToDo>

}