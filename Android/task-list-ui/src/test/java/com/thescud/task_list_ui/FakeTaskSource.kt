package com.thescud.task_list_ui

import com.thescud.tasks_api.Task
import com.thescud.tasks_api.TasksSource
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.flowOf

class FakeTaskSource : TasksSource {

    private var currentId = 0
    private val tasks = MutableStateFlow(listOf<Task>())

    override fun getAllTasks(): Flow<List<Task>> = tasks.asStateFlow()

    override fun getTaskById(id: Int): Flow<Task> = flowOf(tasks.value.first { it.id == id })

    override suspend fun changeTaskState(id: Int, completed: Boolean) {
        val task = tasks.value.first { it.id == id }
        (task as StubTaskImpl).completed = completed
    }

    override suspend fun insertTask(shortDescription: String) {
        tasks.value += StubTaskImpl(id = currentId++, shortDesc = shortDescription)
    }

    override suspend fun deleteTask(id: Int) {
        tasks.value = tasks.value.filter { it.id != id }
    }
}