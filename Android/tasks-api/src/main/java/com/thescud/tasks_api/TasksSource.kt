package com.thescud.tasks_api

import kotlinx.coroutines.flow.Flow

interface TasksSource {
    fun getAllTasks(): Flow<List<Task>>
    fun getTaskById(id: Int): Flow<Task>
    suspend fun changeTaskState(id: Int, completed: Boolean)
}