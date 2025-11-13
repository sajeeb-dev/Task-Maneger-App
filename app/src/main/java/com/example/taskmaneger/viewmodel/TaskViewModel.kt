package com.example.taskmaneger.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch
import com.example.taskmaneger.data.Task
import com.example.taskmaneger.repository.TaskRepository


class TaskViewModel(private val repository: TaskRepository) : ViewModel() {

    val allTasks = repository.allTasks

     fun insertTask(task: Task)=viewModelScope.launch {
        repository.insertTask(task)
    }

    fun updateTask(task: Task)=viewModelScope.launch {
        repository.updateTask(task)
    }
    fun deleteTask(task: Task)=viewModelScope.launch {
        repository.deleteTask(task)
    }

    fun getTaskById(taskId: Long,onResult: (Task?) -> Unit) = viewModelScope.launch {
        val task = repository.getTaskById(taskId)
        onResult(task)
    }

}
