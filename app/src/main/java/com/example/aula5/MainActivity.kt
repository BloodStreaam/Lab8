package com.example.aula5

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.aula5.adapters.TodoAdapter
import com.example.aula5.models.Todo
import kotlinx.android.synthetic.main.activity_main.*
import java.time.LocalDate

class MainActivity : AppCompatActivity() {

    //Permite inicalizar a variavel mais tarde
    private lateinit var todosAdapter: TodoAdapter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        todosAdapter = TodoAdapter(ArrayList())

        rvTodoItems.adapter = todosAdapter
        rvTodoItems.layoutManager = LinearLayoutManager(this)

        btnAddTodo.setOnClickListener{
            val todoTitle = etTodo.text.toString()
            if(todoTitle.isNotEmpty()){
                val todo = Todo(todoTitle, LocalDate.now())

                todosAdapter.addTodo(todo)

                etTodo.text.clear()
            }

        }
    }
}