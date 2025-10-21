package com.example.todoapplicatonpro.ui.viewmodels

import androidx.lifecycle.ViewModel
import com.example.todoapplicatonpro.data.repos.ToDoRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject


@HiltViewModel
class SaveViewModel @Inject constructor(
    var repository: ToDoRepository
) : ViewModel() {


    fun saveNewToDos(name : String) {
        CoroutineScope(Dispatchers.Main).launch {
            repository.save(name)
        }
    }
}