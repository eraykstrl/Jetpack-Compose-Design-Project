package com.example.todoapplicatonpro.ui.viewmodels

import android.util.Log
import androidx.lifecycle.ViewModel
import com.example.todoapplicatonpro.data.repos.ToDoRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject


@HiltViewModel
class UpdateViewModel @Inject constructor(
    var repository: ToDoRepository
) : ViewModel() {


    fun updateCurrentToDos(id : Int,name : String) {
        Log.e("Update Screen","Şu an viewmodeldeyiz id : $id ve name $name")
        CoroutineScope(Dispatchers.Main).launch {
            repository.updateToDo(id,name)
        }
    }
}