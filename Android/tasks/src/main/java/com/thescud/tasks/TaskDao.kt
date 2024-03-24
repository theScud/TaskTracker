package com.thescud.tasks

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import kotlinx.coroutines.flow.Flow

@Dao
interface TaskDao {

    @Query("SELECT * FROM tasktable")
    fun getAllTasks(): Flow<List<TaskTable>>

    @Query("SELECT * FROM tasktable WHERE id = :id LIMIT 1")
    fun getTaskWithId(id: Int): Flow<TaskTable>

    @Insert
    suspend fun insertTask(task: TaskTable)

    @Query("UPDATE tasktable SET completed = :completed WHERE id = :id")
    suspend fun updateTask(id: Int, completed: Boolean)

    @Query("DELETE FROM tasktable WHERE id = :id")
    suspend fun deleteTask(id: Int)
}