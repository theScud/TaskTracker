package com.thescud.task_list_item_ui

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Checkbox
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.ImeAction

@Composable
fun EditableTaskListItem(modifier: Modifier = Modifier, onSend: (String) -> Unit) {
    var currentText by remember { mutableStateOf("") }
    TextField(
        modifier = modifier,
        value = currentText,
        label = { Text(text = "Add new task") },
        onValueChange = { currentText = it },
        keyboardOptions = KeyboardOptions(
            imeAction = ImeAction.Send
        ),
        maxLines = 1,
        keyboardActions = KeyboardActions(
            onSend = { onSend(currentText) }
        ),
    )
}

@Composable
fun TaskListItem(modifier: Modifier = Modifier, shortDescription: String) {
    var checkedState by remember { mutableStateOf(false) }
    Row(modifier) {
        Checkbox(
            modifier = modifier,
            checked = checkedState,
            onCheckedChange = { checkedState = it },
        )
        Text(modifier = modifier.align(Alignment.CenterVertically), text = shortDescription)
    }
}