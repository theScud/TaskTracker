package com.thescud.tasks

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.thescud.tasks_api.Task

@Entity
data class TaskTable(
    @PrimaryKey override val id: Int,
    @ColumnInfo(name = "short_description") val shortDesc: String?,
    @ColumnInfo(name = "detailed_description") val longDesc: String?,
    @ColumnInfo(name = "completed") val completed: Boolean = false
) : Task {

    override fun shortDescription(): String = shortDesc.orEmpty()

    override fun detailedDescription(): String = longDesc.orEmpty()
}
