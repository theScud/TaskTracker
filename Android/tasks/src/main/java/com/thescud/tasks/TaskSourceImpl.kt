package com.thescud.tasks

import com.thescud.tasks_api.Task
import com.thescud.tasks_api.TasksSource
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class TaskSourceImpl @Inject constructor(private val taskDao: TaskDao) : TasksSource {

    override fun getAllTasks(): Flow<List<Task>> {
        return taskDao.getAllTasks()
    }

    override fun getTaskById(id: Int): Flow<Task> {
        return taskDao.getTaskWithId(id)
    }

    override suspend fun changeTaskState(id: Int, completed: Boolean) {
        taskDao.updateTask(id, completed)
    }

    override suspend fun insertTask(shortDescription: String) {
        taskDao.insertTask(TaskTable(shortDesc = shortDescription))
    }

    override suspend fun deleteTask(id: Int) {
        taskDao.deleteTask(id)
    }
}