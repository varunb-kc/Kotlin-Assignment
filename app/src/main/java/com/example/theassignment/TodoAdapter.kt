package com.example.theassignment

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class TodoAdapter (
    private val todoList: MutableList<Todo>
): RecyclerView.Adapter<TodoAdapter.TodoViewHolder>()
{
    class TodoViewHolder(itemView: View): RecyclerView.ViewHolder(itemView){
        val todoTxt: TextView = itemView.findViewById(R.id.todoText)
        val deleteBtn: ImageView = itemView.findViewById(R.id.delImg)
    }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TodoViewHolder {
        return TodoViewHolder(
            LayoutInflater.from(parent.context).inflate(
                R.layout.todo_item,
                parent,
                false
            )
        )
    }

    override fun getItemCount(): Int = todoList.size

    fun addTodo( todo: Todo ){
        todoList.add(todo)
        notifyItemChanged(todoList.size - 1)
    }

    override fun onBindViewHolder(holder: TodoViewHolder, position: Int) {

        val currentTodo = todoList[position]

        holder.todoTxt.text = currentTodo.value
        holder.deleteBtn.setOnClickListener {
            todoList.removeAt(position)
            notifyDataSetChanged()
        }

    }


}