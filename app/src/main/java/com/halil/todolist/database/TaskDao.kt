package com.halil.todolist.database

import androidx.lifecycle.LiveData
import androidx.room.*


@Dao
interface TaskDao {

    @Insert
    suspend fun insert (taskEntry: TaskEntry)

    @Delete
    suspend fun delete (taskEntry: TaskEntry)

    @Update
    suspend fun update (taskEntry: TaskEntry)

    @Query("DELETE FROM task_table")
    suspend fun deleteAll ()

    @Query("SELECT * FROM task_table ORDER BY timestamp DESC")
    fun getAllTasks (): LiveData<List<TaskEntry>>

}