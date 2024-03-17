package com.thescud.tasks

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update

@Dao
interface TaskDao {

    @Query("SELECT * FROM tasktable")
    fun getAllTasks(): List<TaskTable>

    @Query("SELECT * FROM tasktable WHERE id = :id LIMIT 1")
    fun getTaskWithId(id: Int): TaskTable

    @Insert
    fun insertTask(task: TaskTable)

    @Update
    fun updateTask(task: TaskTable)
}