package com.thescud.tasks

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.thescud.tasks_api.Task

@Entity
data class TaskTable(
    @PrimaryKey(autoGenerate = true) override val id: Int = 0,
    @ColumnInfo(name = "short_description") val shortDesc: String? = null,
    @ColumnInfo(name = "detailed_description") val longDesc: String? = null,
    @ColumnInfo(name = "completed") val completed: Boolean = false
) : Task {

    override fun shortDescription(): String = shortDesc.orEmpty()

    override fun detailedDescription(): String = longDesc.orEmpty()
}
