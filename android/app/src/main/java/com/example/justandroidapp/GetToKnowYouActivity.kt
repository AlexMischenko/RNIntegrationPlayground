package com.example.justandroidapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.justandroidapp.databinding.ActivityGetToKnowYouBinding
import com.google.android.material.snackbar.Snackbar

class GetToKnowYouActivity : AppCompatActivity() {
    private lateinit var binding: ActivityGetToKnowYouBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityGetToKnowYouBinding.inflate(layoutInflater)
        setContentView(binding.root)

        initListeners()
    }

    private fun initListeners () {
        binding.submitInfoButton.setOnClickListener {
            val firstName = binding.firstNameInput.text.toString()
            val favoriteColor = binding.favoriteColorInput.text.toString()
            val favoriteSnack = binding.favoriteSnackInput.text.toString()

            val infoMessage = getString(R.string.info_message_template, firstName, favoriteColor, favoriteSnack)

            Snackbar.make(it, "Info is gathered", Snackbar.LENGTH_LONG)
                .setAction("Show info") {
                    Toast.makeText(this, infoMessage, Toast.LENGTH_LONG).show()
                }
                .show()

        }
    }
}