package com.example.myapplication

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.myapplication.databinding.ActivityDetailsdogsBinding
import com.example.myapplication.viewModel.ImageClass
import com.squareup.picasso.Picasso

class DetailsDogsActivity : AppCompatActivity() {
    private lateinit var binding: ActivityDetailsdogsBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDetailsdogsBinding.inflate(layoutInflater)
        setContentView(binding.root)

        loadImage()

        binding.imBtnBack.setOnClickListener{
            startActivity(Intent(this, MainActivity::class.java))
        }
        binding.foodButton.setOnClickListener{
            binding.tvFeatures.setText("Ese perrito come mucho ceral")
        }
        binding.doctorButton.setOnClickListener{
            binding.tvFeatures.setText("Ese perrito tiene que ir periodicamente al veterinario")
        }
        binding.homeButton.setOnClickListener{
            binding.tvFeatures.setText("Ese perrito vive en ambiente tropical")
        }
        binding.pawButton.setOnClickListener{
            binding.tvFeatures.setText("Ese perrito su raza es unica")
        }

    }

    private fun loadImage() {
        Picasso.get().load(ImageClass.imageGrid).into(binding.imDetail)
    }
}