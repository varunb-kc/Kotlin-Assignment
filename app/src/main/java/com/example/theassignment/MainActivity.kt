package com.example.theassignment

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.theassignment.data.UserData
import java.util.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        supportActionBar?.hide()

        setContentView(R.layout.activity_main)

        val signUpBtn = findViewById<Button>(R.id.signup)
        val loginBtn = findViewById<Button>(R.id.login)
        val userName = findViewById<EditText>(R.id.username)
        val password = findViewById<EditText>(R.id.passw)

        loginBtn.setOnClickListener {
            navigateToLogin()
        }

        signUpBtn.setOnClickListener {

            val usernameText = userName.text.toString().trim()
            val passwordTxt = password.text.toString().trim()

            if (usernameText.isEmpty() or passwordTxt.isEmpty() ){
                return@setOnClickListener
            }

            createUserData(usernameText, passwordTxt)

            userName.text.clear()
            password.text.clear()
        }

    }

    private fun createUserData(name: String, password: String ) {

        val result = UserData.createUser(name.toLowerCase(Locale.ROOT), password)

        if ( result ){
            Toast.makeText(this, "User Created", Toast.LENGTH_SHORT).show()
        }else {
            Toast.makeText(this, "User exists", Toast.LENGTH_SHORT).show()
        }

    }

    private fun navigateToLogin(){
        val intent = Intent( this, LoginActivity::class.java )
        this.startActivity(intent)
    }

}
