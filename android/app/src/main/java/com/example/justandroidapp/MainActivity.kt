package com.example.justandroidapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import com.example.justandroidapp.databinding.ActivityMainBinding
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private val testButtons by lazy {
        arrayListOf<Button>(button4, button5, button6)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        lifecycle.addObserver(MainLifecycleObserver())

        addSomeViews(5)
        for (testButton in testButtons) {
            testButton.text = "renamed"
        }
        button4.text = "RN"
        button4.setOnClickListener {
            val intent = Intent(this@MainActivity, RNModuleActivity::class.java)
            intent.putExtra("message_from_native", "Native Android Rules!!!")
            startActivity(intent)
        }
    }

    private fun addSomeViews (count: Int) {
        for (i in 1..count) {
            val newTextView = TextView(this)
            newTextView.text = "New text # $i"
            newTextView.textSize = 20f

            my_layout.addView(newTextView)
        }

        // Generate "Go to Login" button
        val goLoginButton = Button(this)
        goLoginButton.text = getString(R.string.go_to_login)
        goLoginButton.setOnClickListener {
            val intent = Intent(this, LoginActivity::class.java)
            startActivity(intent)
        }
        binding.myLayout.addView(goLoginButton)

        // Generate "Go to GetToKnowYou from" button
        val goToFormButton = Button(this)
        goToFormButton.text = getString(R.string.get_to_know_you_form)
        goToFormButton.setOnClickListener {
            val intent = Intent(this, GetToKnowYouActivity::class.java)
            startActivity(intent)
        }
        binding.myLayout.addView(goToFormButton)

        // Generate "Go to Image Test" button
        val goImageTestButton = Button(this)
        goImageTestButton.text = getString(R.string.go_to_image_test)
        goImageTestButton.setOnClickListener {
            val intent = Intent(this, ImageTestActivity::class.java)
            startActivity(intent)
        }
        binding.myLayout.addView(goImageTestButton)


//        Also valid ways to add a View
//        my_layout.addView(newButton)
//        findViewById<LinearLayout>(R.id.my_layout).addView(newButton)
    }
}