package com.example.myapplication

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    private lateinit var credentialsManager: CredentialsManager

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.registration_activity)

        credentialsManager = CredentialsManager(this)

        val emailEditText = findViewById<EditText>(R.id.email_text)
        val passwordEditText = findViewById<EditText>(R.id.password_text)
        val registerButton = findViewById<Button>(R.id.nextButton)

        registerButton.setOnClickListener {
            val email = emailEditText.text.toString()
            val password = passwordEditText.text.toString()

            if (!CredentialsManager.isValidEmail(email)) {
                emailEditText.error = "Invalid email format"
            } else if (!CredentialsManager.isValidPassword(password)) {
                passwordEditText.error = "Password must be at least 8 characters, with an uppercase letter and a digit"
            } else {
                if (credentialsManager.registerAccount(email, password)) {
                    val intent = Intent(this, LoginActivity::class.java)
                    startActivity(intent)
                    finish()
                } else {
                    emailEditText.error = "Email already registered"
                }
            }
        }

        findViewById<TextView>(R.id.login_next_text_view).setOnClickListener {
            val intent = Intent(this, LoginActivity::class.java)
            startActivity(intent)
            finish()
        }
    }
}
