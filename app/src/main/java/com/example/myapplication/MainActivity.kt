package com.example.myapplication

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    private lateinit var credentialsManager: CredentialsManager

    // Lazy initialization for views
    private val emailEditText: EditText by lazy { findViewById(R.id.email_text) }
    private val passwordEditText: EditText by lazy { findViewById(R.id.password_text) }
    private val registerButton: Button by lazy { findViewById(R.id.nextButton) }
    private val loginNextTextView: TextView by lazy { findViewById(R.id.login_next_text_view) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.registration_activity)

        credentialsManager = CredentialsManager(this)

        registerButton.setOnClickListener {
            val email = emailEditText.text.toString()
            val password = passwordEditText.text.toString()

            // Validation logic
            when {
                !CredentialsManager.isValidEmail(email) -> {
                    emailEditText.error = "Invalid email format"
                }
                !CredentialsManager.isValidPassword(password) -> {
                    passwordEditText.error = "Password must be at least 8 characters, with an uppercase letter and a digit"
                }
                !credentialsManager.isEmailAvailable(email) -> {
                    emailEditText.error = "Email already registered"
                }
                credentialsManager.registerAccount(email, password) -> {
                    // Successful registration
                    startActivity(Intent(this, LoginActivity::class.java))
                    finish()
                }
                else -> {
                    emailEditText.error = "Email already registered"
                }
            }
        }

        loginNextTextView.setOnClickListener {
            // Navigate to LoginActivity
            startActivity(Intent(this, LoginActivity::class.java))
            finish()
        }
    }
}
