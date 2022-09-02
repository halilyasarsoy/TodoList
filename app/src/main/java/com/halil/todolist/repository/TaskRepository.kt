package com.halil.todolist.repository

import androidx.lifecycle.LiveData
import com.halil.todolist.database.TaskDao
import com.halil.todolist.database.TaskEntry


class TaskRepository(val taskDao: TaskDao) {
    suspend fun insert(taskEntry: TaskEntry) = taskDao.insert(taskEntry)

    suspend fun updateData(taskEntry: TaskEntry) = taskDao.insert(taskEntry)

    suspend fun deleteItem(taskEntry: TaskEntry) = taskDao.insert(taskEntry)

    suspend fun deleteAll(){
        taskDao.deleteAll()
    }
    fun gelAllTasks() : LiveData<List<TaskEntry>> = taskDao.getAllTasks()
}