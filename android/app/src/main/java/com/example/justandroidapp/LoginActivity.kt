package com.example.justandroidapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import com.example.justandroidapp.databinding.ActivityLoginBinding
import com.google.android.material.snackbar.Snackbar

class LoginActivity : AppCompatActivity() {
    private lateinit var binding: ActivityLoginBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.button.setOnClickListener {
            val email = binding.editTextTextEmailAddress.text.toString()
            val password = binding.editTextNumberPassword.text.toString()

            Log.i("log", "onCreate: email: $email")
            Log.i("log", "onCreate: password: $password")
            Log.i("log", "")

            val emailInput = binding.emailInput.text.toString()
            val passwordInput = binding.passwordInput.text.toString()

            val message1 = getString(R.string.login_form_template, email, password)
            val message2 = getString(R.string.login_form_template, emailInput, passwordInput)

//            showMessage(message1)
//            showMessage(message2)

            Snackbar.make(it, "message1", Snackbar.LENGTH_INDEFINITE)
                .setAction("Show info") { showMessage((message1)) }
                .show()

            Snackbar.make(it, "message2", Snackbar.LENGTH_INDEFINITE)
                .setAction("Show info") { showMessage((message2)) }
                .show()

            Log.i("log", "onCreate: emailInput: $emailInput")
            Log.i("log", "onCreate: passwordInput: $passwordInput")
            Log.i("log", "")
        }
    }

    private fun showMessage(message1: String) {
        Toast.makeText(this, message1, Toast.LENGTH_SHORT).show()
    }
}