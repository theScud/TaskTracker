package com.thescud.task_list_ui

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.thescud.tasks_api.TasksSource
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class TaskListViewModel @Inject constructor(private val tasksSource: TasksSource) : ViewModel() {

    private val _tasks = tasksSource.getAllTasks()
        .map { taskList -> taskList.map { it.shortDescription() } }
        .stateIn(viewModelScope, SharingStarted.Lazily, listOf())

    val tasks: StateFlow<List<String>>
        get() = _tasks

    fun addTask(shortDescription: String) {
        viewModelScope.launch(Dispatchers.IO) {
            tasksSource.insertTask(shortDescription)
        }
    }
}