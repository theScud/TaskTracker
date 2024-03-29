@file:OptIn(ExperimentalMaterial3Api::class)

package com.thescud.task_list_item_ui

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Delete
import androidx.compose.material3.Checkbox
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.SwipeToDismissBox
import androidx.compose.material3.SwipeToDismissBoxValue
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.rememberSwipeToDismissBoxState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

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
fun TaskListItem(
    modifier: Modifier = Modifier,
    shortDescription: String,
    completed: Boolean,
    id: Int,
    onCheckedChanged: (Boolean) -> Unit,
    onDelete: (Int) -> Unit
) {
    val swipeState = rememberSwipeToDismissBoxState()
    SwipeToDismissBox(
        state = swipeState,
        backgroundContent = { DeleteBackground() },
        enableDismissFromEndToStart = true,
        enableDismissFromStartToEnd = false,
    ) {
        Row(
            modifier
                .background(Color.White)
                .fillMaxWidth()
        ) {
            Checkbox(
                modifier = modifier,
                checked = completed,
                onCheckedChange = { onCheckedChanged(it) },
            )
            Text(
                modifier = modifier.align(Alignment.CenterVertically),
                text = shortDescription,
                style = TextStyle(textDecoration = textDecoration(completed)),
                fontSize = 18.sp
            )
        }

        if (swipeState.currentValue == SwipeToDismissBoxValue.EndToStart) onDelete(id)
    }
}

@Composable
fun DeleteBackground() {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .fillMaxHeight()
            .background(Color.Red),
        contentAlignment = Alignment.CenterEnd,
    ) {
        Icon(
            Icons.Default.Delete,
            contentDescription = "Delete",
            modifier = Modifier.padding(8.dp)
        )
    }
}

private fun textDecoration(completed: Boolean) =
    if (completed) TextDecoration.LineThrough else TextDecoration.None