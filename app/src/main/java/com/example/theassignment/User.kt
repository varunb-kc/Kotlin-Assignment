package com.example.theassignment

data class User (
  val name: String,
  val password: String,
  val todos: MutableList<Todo>
)