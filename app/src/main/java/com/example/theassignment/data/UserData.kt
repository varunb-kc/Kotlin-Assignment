package com.example.theassignment.data

import com.example.theassignment.Todo
import com.example.theassignment.User

class UserData {
    companion object TheData {
        private val UsersTodoMap: MutableMap<String, User > = mutableMapOf()

        fun getTodo( user: String ): MutableList<Todo> {
            val theUser = UsersTodoMap[user]
            return theUser?.todos ?: mutableListOf()
        }

        fun createUser(name: String, password: String ): Boolean {
            return if( UsersTodoMap[name] == null ){
                val newUser = User( name, password, mutableListOf() )
                UsersTodoMap[name] = newUser
                true
            } else {
                false
            }
        }

        fun logUserIn( name: String, password: String ): Boolean? {
            val theUser = UsersTodoMap[name] ?: return null
            return theUser.password == password
        }


    }
}