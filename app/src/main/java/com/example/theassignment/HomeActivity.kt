package com.example.theassignment

import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.theassignment.data.UserData
import java.util.*


class HomeActivity : AppCompatActivity() {

    private lateinit var todoAdapter: TodoAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)

        supportActionBar?.setBackgroundDrawable(ColorDrawable( Color.parseColor("#334455") ))


        val username = intent?.extras?.getString("name").toString() ?: "User"
        title = "Hello $username!"


        val theTodos = UserData.getTodo(username.toLowerCase(Locale.ROOT))

        todoAdapter = TodoAdapter(theTodos)

        val recyclerView = findViewById<RecyclerView>(R.id.rvTodos)
        val addBtn = findViewById<Button>(R.id.btnAdd)
        val editTodo = findViewById<EditText>(R.id.addTodo)

        recyclerView.adapter = todoAdapter
        recyclerView.layoutManager = LinearLayoutManager(this)

        addBtn.setOnClickListener {
            val todoTitle = editTodo.text.toString().trim()
            if(todoTitle.isNotEmpty()){
                val newTodo = Todo(todoTitle)
                todoAdapter.addTodo(newTodo)
                editTodo.text.clear()
            }
        }
    }
}