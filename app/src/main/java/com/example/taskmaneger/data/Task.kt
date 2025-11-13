package com.example.taskmaneger.data

import androidx.room.Entity
import androidx.room.PrimaryKey
import java.util.Date

@Entity(tableName = "tasks")
data class Task(
    @PrimaryKey(autoGenerate = true) val id: Long = 0,
    val title: String,
    val description: String,
    val priority: Long=1, //1 for low, 2 for medium, 3 for high
    val isCompleted: Boolean = false,
    val createdAt: Long= Date().time

){

    fun getPriorityColor(): Long{
        return when(priority){
            3L -> 0xFFFF5252   //Red for high
            2L -> 0xFFFFB74D   //Orange for medium
            else -> 0xFF4CAF50 //Green for low

        }
    }
    fun getPriorityText(): String{
        return when(priority){
            3L -> "High"
            2L -> "Medium"
            else -> "Low"
        }
    }
}
