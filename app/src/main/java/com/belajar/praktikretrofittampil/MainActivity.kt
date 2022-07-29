package com.belajar.praktikretrofittampil

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity() {

    private val api by lazy { ApiRetrofit().apiEndPoint }
    lateinit var todosAdapter: TodosAdapter
    lateinit var recyclerView: RecyclerView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        tampilData()
    }

    override fun onStart() {
        super.onStart()
        getData()
    }

    fun tampilData(){
        recyclerView = findViewById(R.id.recycle)
        val linearLayoutManager = LinearLayoutManager(this)
        recyclerView.layoutManager = linearLayoutManager
        todosAdapter = TodosAdapter(arrayListOf())
        recyclerView.adapter = todosAdapter
    }

    fun getData(){

        api.tampilTodos().enqueue(object : Callback<TodosModel>{
            override fun onResponse(call: Call<TodosModel>, response: Response<TodosModel>) {
                val listData = response.body()!!.todos
                todosAdapter.setData(listData)

            }

            override fun onFailure(call: Call<TodosModel>, t: Throwable) {
                TODO("Not yet implemented")
            }
        })

    }
}