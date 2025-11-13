package com.example.taskmaneger.data

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(entities = [Task::class], version = 1, exportSchema = false)
abstract class TaskDataBase: RoomDatabase(){
    abstract fun taskDao(): TaskDao

    companion object{
        @Volatile
        private var INSTANCE: TaskDataBase? = null

        fun getDatabase(context: Context): TaskDataBase{
            return INSTANCE ?: synchronized(this){
                val instance = Room.databaseBuilder(

                    context.applicationContext,
                    TaskDataBase::class.java,
                    "task_database"
                    ).build()
                INSTANCE = instance
                instance






            }
        }
    }
}


