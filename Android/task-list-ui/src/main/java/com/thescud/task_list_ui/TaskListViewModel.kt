package com.thescud.task_list_ui

import androidx.lifecycle.ViewModel
import com.thescud.tasks_api.TasksSource
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import javax.inject.Inject

@HiltViewModel
class TaskListViewModel @Inject constructor(private val tasksSource: TasksSource) : ViewModel() {

    private val _tasks = MutableStateFlow<List<String>>(emptyList())
    val tasks: StateFlow<List<String>>
        get() = _tasks

    fun addTask(shortDescription: String) {
        _tasks.value += shortDescription
    }
}