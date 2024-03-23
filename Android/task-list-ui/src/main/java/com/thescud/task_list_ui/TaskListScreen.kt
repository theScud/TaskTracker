package com.thescud.task_list_ui

import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.lifecycle.viewmodel.compose.viewModel
import com.thescud.task_list_item_ui.EditableTaskListItem
import com.thescud.task_list_item_ui.TaskListItem

@Composable
fun TaskListScreen(modifier: Modifier = Modifier) {
    val viewModel = viewModel<TaskListViewModel>()
    val items by viewModel.tasks.collectAsState()
    LazyColumn(
        modifier
            .fillMaxHeight()
            .fillMaxWidth()) {
        items.forEach {
            item {
                TaskListItem(Modifier, it)
            }
        }
        item {
            EditableTaskListItem(Modifier.fillMaxWidth()) { viewModel.addTask(it) }
        }
    }
}