package com.example.todoapplicatonpro.di

import android.content.Context
import androidx.room.Room
import com.example.todoapplicatonpro.data.datasources.ToDoDatasource
import com.example.todoapplicatonpro.data.repos.ToDoRepository
import com.example.todoapplicatonpro.room.ToDoDao
import com.example.todoapplicatonpro.room.ToDosDatabase


import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class AppModule {

    @Provides
    @Singleton
    fun provideRepository(toDosDatasource: ToDoDatasource) : ToDoRepository {
        return ToDoRepository(toDosDatasource)
    }

    @Provides
    @Singleton
    fun provideDatasource(toDosDao : ToDoDao) : ToDoDatasource {
        return ToDoDatasource(toDosDao)
    }

    @Provides
    @Singleton
    fun provideDao(@ApplicationContext context: Context) : ToDoDao {

        val db = Room
            .databaseBuilder(
                context,
                ToDosDatabase::class.java,
                "toDosDatabase"
            )
            .createFromAsset("to_do_pro.sqlite")
            .build()

        return db.toDos()

    }
}