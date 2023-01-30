package com.tutorialwing.haslo

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast

class MainActivity : AppCompatActivity() {

    private lateinit var passwordEditText: EditText
    private lateinit var passwordAgainEditText: EditText
    private lateinit var checkButton: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        passwordEditText = findViewById(R.id.editTextTextPassword)
        passwordAgainEditText = findViewById(R.id.editTextTextPassword2)
        checkButton = findViewById(R.id.button)

        checkButton.setOnClickListener {
            val password = passwordEditText.text.toString()
            val passwordAgain = passwordAgainEditText.text.toString()
            if (password == passwordAgain) {
                if (checkPassword(password)) {
                    Toast.makeText(this, "Hasło jest poprawne", Toast.LENGTH_SHORT).show()
                } else {
                    Toast.makeText(this, "Hasło musi zawierać co najmniej jedną wielką literę, jedną małą literę, jedną cyfrę i jeden znak specjalny", Toast.LENGTH_SHORT).show()
                }
            } else {
                Toast.makeText(this, "Hasła nie są zgodne", Toast.LENGTH_SHORT).show()
            }
        }
    }

    private fun checkPassword(password: String): Boolean {
        var hasUpper = false
        var hasLower = false
        var hasDigit = false
        var hasSpecial = false
        for (char in password) {
            if (char.isUpperCase()) {
                hasUpper = true
            } else if (char.isLowerCase()) {
                hasLower = true
            } else if (char.isDigit()) {
                hasDigit = true
            } else if (!char.isLetterOrDigit()) {
                hasSpecial = true
            }
        }
        return hasUpper && hasLower && hasDigit && hasSpecial
    }
}