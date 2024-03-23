package com.thescud.task_list_ui

import kotlinx.coroutines.flow.first
import kotlinx.coroutines.runBlocking
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Assertions.assertTrue
import org.junit.jupiter.api.Test

class TaskListViewModelTest {

    private lateinit var objectUnderTest: TaskListViewModel

    @Test
    fun `when new entry added to VM then VM returns new list`() {
        objectUnderTest = TaskListViewModel()
        val expected = "New task"

        runBlocking {
            assertTrue(objectUnderTest.tasks.first().isEmpty())
            objectUnderTest.addTask(expected)

            assertEquals(listOf(expected), objectUnderTest.tasks.first())
        }
    }
}