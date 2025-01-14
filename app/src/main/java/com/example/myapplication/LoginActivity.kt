package com.example.myapplication

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class LoginActivity : AppCompatActivity() {

    private lateinit var credentialsManager: CredentialsManager

    // Define properties for views with lazy initialization
    private val emailEditText: EditText by lazy { findViewById(R.id.email_text) }
    private val passwordEditText: EditText by lazy { findViewById(R.id.password_text) }
    private val loginButton: Button by lazy { findViewById(R.id.nextButton) }
    private val registerNowTextView: TextView by lazy { findViewById(R.id.register_now_text_view) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.login_activity)

        credentialsManager = CredentialsManager(this)

        // Set click listener for loginButton
        loginButton.setOnClickListener {
            val email = emailEditText.text.toString()
            val password = passwordEditText.text.toString()

            // First check if the email format is valid
            if (!CredentialsManager.isValidEmail(email)) {
                emailEditText.error = "Invalid email format"
            } else if (credentialsManager.isValidAdminLogin(email, password)) {
                // Admin login check (no password validation)
                val intent = Intent(this, MainActivity::class.java)
                startActivity(intent)
                finish()
            } else if (!CredentialsManager.isValidPassword(password)) {
                // Password format check (only for regular users)
                passwordEditText.error = "Password must be at least 8 characters, with an uppercase letter and a digit"
            } else {
                // Regular user login check
                if (credentialsManager.isValidLogin(email, password)) {
                    val intent = Intent(this, MainActivity::class.java)
                    startActivity(intent)
                    finish()
                } else {
                    passwordEditText.error = "Incorrect credentials"
                }
            }
        }

        // Set click listener for registerNowTextView
        registerNowTextView.setOnClickListener {
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
            finish()
        }
    }
}
