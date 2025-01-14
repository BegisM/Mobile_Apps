package com.example.myapplication

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class LoginActivity : AppCompatActivity() {

    private lateinit var credentialsManager: CredentialsManager

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.login_activity)

        credentialsManager = CredentialsManager(this)

        val emailEditText = findViewById<EditText>(R.id.email_text)
        val passwordEditText = findViewById<EditText>(R.id.password_text)
        val loginButton = findViewById<Button>(R.id.nextButton)

        loginButton.setOnClickListener {
            val email = emailEditText.text.toString()
            val password = passwordEditText.text.toString()

            if (!CredentialsManager.isValidEmail(email)) {
                emailEditText.error = "Invalid email format"
            } else if (!CredentialsManager.isValidPassword(password)) {
                passwordEditText.error = "Password must be at least 8 characters, with an uppercase letter and a digit"
            } else {
                // Validate login credentials
                if (credentialsManager.isValidLogin(email, password)) {
                    val intent = Intent(this, MainActivity::class.java)
                    startActivity(intent)
                    finish()
                } else {
                    passwordEditText.error = "Incorrect credentials"
                }
            }
        }

        findViewById<TextView>(R.id.register_now_text_view).setOnClickListener {
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
            finish()
        }
    }
}
