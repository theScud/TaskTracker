package com.thescud.tasks_api

interface TasksSource {
    fun getAllTasks(): List<Task>
    fun getTaskById(id: Int): Task
    fun changeTaskState(id: Int, completed: Boolean)
}