package com.dicoding.todoapp.data

import androidx.room.Entity
import androidx.room.PrimaryKey

//TODO 1 : Define a local database table using the schema in app/schema/tasks.json

@Entity(tableName = "tasks")
data class Task(
    @PrimaryKey(autoGenerate = true) val id: Int = 0,
    val title: String,
    val description: String,
    val dueDate: Long,
    val completed: Boolean
)
