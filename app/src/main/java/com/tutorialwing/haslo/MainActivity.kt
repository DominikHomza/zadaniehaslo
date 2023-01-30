package com.tutorialwing.haslo

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast

class MainActivity : AppCompatActivity() {
    private lateinit var passwordTextView: TextView
    private lateinit var passwordEditText: EditText
    private lateinit var repeatPasswordEditText: EditText
    private lateinit var checkButton: Button


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        passwordEditText = findViewById(R.id.editTextTextPassword)
        repeatPasswordEditText = findViewById(R.id.editTextTextPassword2)
        checkButton = findViewById(R.id.button)
        passwordTextView = findViewById(R.id.textView)

        checkButton.setOnClickListener {
            val password = passwordEditText.text.toString()
            val repeatPassword = repeatPasswordEditText.text.toString()
            var isValid = true

            if (password != repeatPassword) {
                passwordTextView.text = "Hasła nie są takie same."
                isValid = false
            }

            if (!password.matches(".*[A-Z].*".toRegex())) {
                passwordTextView.text = "${passwordTextView.text}\nHasło powinno zawierać przynajmniej jedną wielką literę."
                isValid = false
            }

            if (!password.matches(".*[a-z].*".toRegex())) {
                passwordTextView.text = "${passwordTextView.text}\nHasło powinno zawierać przynajmniej jedną małą literę."
                isValid = false
            }

            if (!password.matches(".*\\d.*".toRegex())) {
                passwordTextView.text = "${passwordTextView.text}\nHasło powinno zawierać przynajmniej jedną cyfrę."
                isValid = false
            }

            if (!password.matches(".*[!@#$%^&*()_+\\-=\\[\\]{};':\"\\\\|,.<>/?].*".toRegex())) {
                passwordTextView.text = "${passwordTextView.text}\nHasło powinno zawierać przynajmniej jeden znak specjalny."
                isValid = false
            }

            if (isValid) {
                passwordTextView.text = "Hasło jest prawidłowe."
            }
        }
    }
}