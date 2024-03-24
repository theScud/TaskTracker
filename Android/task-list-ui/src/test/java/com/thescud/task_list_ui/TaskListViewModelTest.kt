package com.thescud.task_list_ui

import com.thescud.coroutines_test.CoroutineTestExtension
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.test.advanceUntilIdle
import kotlinx.coroutines.test.runTest
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Assertions.assertTrue
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.extension.ExtendWith

@OptIn(ExperimentalCoroutinesApi::class)
@ExtendWith(CoroutineTestExtension::class)
class TaskListViewModelTest {

    private lateinit var objectUnderTest: TaskListViewModel

    @Test
    fun `when new entry added to VM then VM returns new list`() = runTest {
        objectUnderTest = TaskListViewModel(FakeTaskSource())

        val expected = StubTaskImpl(shortDesc = "New task")
        assertTrue(objectUnderTest.tasks.first().isEmpty())
        objectUnderTest.addTask(expected.shortDescription())

        advanceUntilIdle()
        assertEquals(listOf(expected), objectUnderTest.tasks.value)
    }
}