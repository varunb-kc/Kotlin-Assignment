package com.example.theassignment

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.theassignment.data.UserData
import java.util.*

class LoginActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        supportActionBar?.hide()

        val signUpBtn = findViewById<Button>(R.id.loginsignup)
        val loginBtn = findViewById<Button>(R.id.theloginBtn)
        val loginInput = findViewById<EditText>(R.id.loginusername)
        val passwordInput = findViewById<EditText>(R.id.loginPassw)

        signUpBtn.setOnClickListener { navigateToSignUp() }

        loginBtn.setOnClickListener {
            val userName = loginInput.text.toString()
            val password = passwordInput.text.toString()

            if( userName.trim().isEmpty() or password.trim().isEmpty() ){
                return@setOnClickListener
            }

            val result = UserData.logUserIn(userName.toLowerCase(Locale.ROOT), password)

            if( result == null ){
                showToast("User doesn't exist")
            }else if ( !result ){
                showToast("Wrong Credentials!")
            }else {
                showToast("Congratulations")
                navigateToHome(userName)
            }

            loginInput.text.clear()
            passwordInput.text.clear()

        }

    }

    private fun navigateToSignUp() = this.finish()

    private fun showToast( message: String ) = Toast.makeText(this, message, Toast.LENGTH_SHORT).show()

    private fun navigateToHome(name: String){
        val intent = Intent( this, HomeActivity::class.java )
        intent.putExtra("name", name)
        this.startActivity(intent)
    }


}