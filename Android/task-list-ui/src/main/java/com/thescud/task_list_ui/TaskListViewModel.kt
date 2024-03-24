package com.thescud.task_list_ui

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.thescud.coroutines.AppDispatchers
import com.thescud.tasks_api.Task
import com.thescud.tasks_api.TasksSource
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class TaskListViewModel @Inject constructor(private val tasksSource: TasksSource) : ViewModel() {

    private val _tasks = tasksSource.getAllTasks()
        .stateIn(viewModelScope, SharingStarted.Lazily, listOf())

    val tasks: StateFlow<List<Task>>
        get() = _tasks

    fun addTask(shortDescription: String) {
        viewModelScope.launch(AppDispatchers.io) {
            tasksSource.insertTask(shortDescription)
        }
    }

    fun finishTask(id: Int, completed: Boolean) {
        viewModelScope.launch(AppDispatchers.io) {
            tasksSource.changeTaskState(id, completed)
        }
    }

    fun delete(id: Int) {
        viewModelScope.launch(AppDispatchers.io) {
            tasksSource.deleteTask(id)
        }
    }
}