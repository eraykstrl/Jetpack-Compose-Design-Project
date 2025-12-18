package com.example.todoapplicatonpro.data.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey


@Entity(tableName = "to_dos")
data class ToDo(

    @PrimaryKey(autoGenerate = true) @ColumnInfo(name = "id") val id : Int,
    @ColumnInfo(name = "name") val name : String
) {
}