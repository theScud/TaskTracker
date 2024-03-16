package com.thescud.task_list_ui

import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import com.thescud.task_list_item_ui.EditableTaskListItem
import com.thescud.task_list_item_ui.TaskListItem

@Composable
fun TaskListScreen(modifier: Modifier = Modifier) {
    val items = remember { mutableStateListOf("Item 1", "Item 2", "Item 3") }
    LazyColumn(modifier) {
        items.forEach {
            item {
                TaskListItem(modifier, it)
            }
        }
        item {
            EditableTaskListItem { items.add(it) }
        }
    }
}