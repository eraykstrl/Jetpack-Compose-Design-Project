package com.example.todoapplicatonpro.ui.viewmodels

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.todoapplicatonpro.data.entity.ToDo
import com.example.todoapplicatonpro.data.repos.ToDoRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(
    var repository: ToDoRepository
) : ViewModel() {

    init {
        getAll()
    }

    var toDosList = MutableLiveData<List<ToDo>>()

    fun deleteToDos(id : Int) {
        CoroutineScope(Dispatchers.Main).launch {
            repository.deleteToDo(id)
            getAll()

        }
    }

    fun getAll() {
        CoroutineScope(Dispatchers.Main).launch {
            toDosList.value = repository.getToDos()
        }
    }

    fun searchToDos(searchText : String) {
        CoroutineScope(Dispatchers.Main).launch {
            toDosList.value = repository.search(searchText)
        }
    }
}