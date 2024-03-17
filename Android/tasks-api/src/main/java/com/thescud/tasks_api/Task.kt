package com.thescud.tasks_api

interface Task {
    val id: Int
    fun shortDescription(): String
    fun detailedDescription(): String
}