package com.thescud.tasks

import android.content.Context
import androidx.room.Room
import com.thescud.tasks_api.TasksSource
import dagger.Binds
import dagger.Module
import dagger.Provides
import dagger.Reusable
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class TasksModule {

    @Provides
    @Singleton
    fun providesTaskTrackerDatabase(@ApplicationContext context: Context): TaskTrackerDatabase {
        return Room.databaseBuilder(context, TaskTrackerDatabase::class.java, "TaskTrackerDB")
            .build()
    }

    @Provides
    @Singleton
    fun providesTaskDao(database: TaskTrackerDatabase): TaskDao {
        return database.taskDao()
    }
}

@Module
@InstallIn(SingletonComponent::class)
abstract class AbstractTaskModule {
    @Binds
    @Reusable
    abstract fun bindsTaskSource(taskSourceImpl: TaskSourceImpl): TasksSource
}