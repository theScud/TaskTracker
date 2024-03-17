package com.thescud.tasks

import androidx.room.Database
import androidx.room.RoomDatabase

@Database(entities = [TaskTable::class], version = 1)
abstract class TaskTrackerDatabase: RoomDatabase() {
    abstract fun taskDao(): TaskDao
}