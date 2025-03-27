package com.magui.myapplication

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class LoginActivity : AppCompatActivity() {
    private lateinit var usernameInput: EditText
    private lateinit var passwordInput: EditText
    private lateinit var loginButton: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        try {
            super.onCreate(savedInstanceState)
            Log.d("LoginActivity", "onCreate started")
            setContentView(R.layout.activity_login)

            usernameInput = findViewById(R.id.usernameInput)
            passwordInput = findViewById(R.id.passwordInput)
            loginButton = findViewById(R.id.loginButton)

            loginButton.setOnClickListener {
                try {
                    val username = usernameInput.text.toString()
                    val password = passwordInput.text.toString()

                    Log.d("LoginActivity", "Login attempt - Username: $username")

                    if (username == "admin" && password == "admin123") {
                        Log.d("LoginActivity", "Login successful")
                        val intent = Intent(this, PortfolioActivity::class.java)
                        startActivity(intent)
                        finish()
                    } else {
                        Log.d("LoginActivity", "Login failed - Invalid credentials")
                        Toast.makeText(this, "Credenciales incorrectas", Toast.LENGTH_SHORT).show()
                    }
                } catch (e: Exception) {
                    Log.e("LoginActivity", "Error during login", e)
                    Toast.makeText(this, "Error al iniciar sesión", Toast.LENGTH_SHORT).show()
                }
            }
        } catch (e: Exception) {
            Log.e("LoginActivity", "Error in onCreate", e)
            Toast.makeText(this, "Error al iniciar la aplicación", Toast.LENGTH_SHORT).show()
        }
    }
} 