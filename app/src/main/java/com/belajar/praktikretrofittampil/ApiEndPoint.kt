package com.belajar.praktikretrofittampil

import retrofit2.Call
import retrofit2.http.GET

interface ApiEndPoint {
    @GET("todos")
    public fun tampilTodos() : Call<TodosModel>
}