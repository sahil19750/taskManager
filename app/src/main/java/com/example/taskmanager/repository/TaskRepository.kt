package com.example.taskmanager.repository

import com.example.taskmanager.data.TaskDao
import com.example.taskmanager.model.Task
import com.example.taskmanager.network.RetrofitInstance

class TaskRepository(private val taskDao: TaskDao) {
    val allTasks = taskDao.getAllTasks()

    suspend fun insert(task: Task) = taskDao.insert(task)
    suspend fun update(task: Task) = taskDao.update(task)
    suspend fun delete(task: Task) = taskDao.delete(task)

    suspend fun fetchTasksFromApiAndSave() {
        try {
            val response = RetrofitInstance.api.getTasks()
            response.forEach { insert(it) } // Save into Room
        } catch (e: Exception) {
            e.printStackTrace()
        }
    }


}
