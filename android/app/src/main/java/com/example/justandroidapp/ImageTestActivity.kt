package com.example.justandroidapp

import android.graphics.drawable.Drawable
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import coil.load
import com.example.justandroidapp.databinding.ActivityImageTestBinding
import kotlinx.android.synthetic.main.activity_image_test.*

class ImageTestActivity : AppCompatActivity() {
    private lateinit var binding: ActivityImageTestBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityImageTestBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.downloadSwitch.setOnCheckedChangeListener { _, isChecked ->
            if (isChecked) {
                binding.testImageView.load("https://artprojectsforkids.org/wp-content/uploads/2021/04/How-to-Draw-Spongebob-Square-Pants.jpeg")
            } else {
                binding.testImageView.load("https://img4.hulu.com/user/v3/artwork/d76d6361-3fbf-4842-8dd7-e05520557280?base_image_bucket_name=image_manager&base_image=dc77878b-30b9-4162-a14b-eebd5cb35d87&size=458x687&format=jpeg")
            }
        }

        button1.setOnClickListener {
            displayImageAsset("pretty_soldier.webp")
        }
        button2.setOnClickListener {
            displayImageAsset("rick_morty.webp")
        }
        button3.setOnClickListener {
            displayImageAsset("sailor_moon.webp")
        }
    }

    private fun displayImageAsset(fileName: String) {
        assets.open(fileName).use {
            val drawable = Drawable.createFromStream(it, null)
            testImageView.setImageDrawable(drawable)
        }
    }


}