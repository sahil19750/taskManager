package com.example.taskmanager.network

import com.example.taskmanager.model.Task
import retrofit2.http.GET

interface TaskApiService {

    @GET("8439bce9-1555-4a9e-a146-8de2e4d3cdbc")
    suspend fun getTasks(): List<Task>

}
