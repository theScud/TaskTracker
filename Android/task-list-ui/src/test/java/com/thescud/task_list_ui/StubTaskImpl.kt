package com.thescud.task_list_ui

import com.thescud.tasks_api.Task

data class StubTaskImpl(
    override val id: Int = 0,
    private val shortDesc: String? = null,
    private val longDesc: String? = null,
    var completed: Boolean = false
) : Task {

    override fun shortDescription(): String = shortDesc.orEmpty()

    override fun detailedDescription(): String = longDesc.orEmpty()

    override fun isComplete(): Boolean = completed
}