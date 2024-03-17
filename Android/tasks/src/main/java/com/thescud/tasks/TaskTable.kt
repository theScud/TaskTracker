package com.thescud.tasks

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class TaskTable(
    @PrimaryKey val id: Int,
    @ColumnInfo(name = "short_description") val shortDesc: String?,
    @ColumnInfo(name = "detailed_description") val longDesc: String?,
    @ColumnInfo(name = "completed") val completed: Boolean = false
)
