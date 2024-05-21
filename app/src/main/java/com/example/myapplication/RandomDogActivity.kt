package com.example.myapplication

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.GridLayoutManager
import com.example.myapplication.databinding.ActivityGriddogsBinding
import com.example.myapplication.databinding.ActivityRandomDogBinding
import com.example.myapplication.viewModel.GridDogViewModel
import com.example.myapplication.viewModel.ImageClass
import com.example.myapplication.viewModel.RandomDogViewModel
import com.example.myapplication.viewModel.StateGridViewModel
import com.example.myapplication.viewModel.StateRandomDogViewModel
import com.squareup.picasso.Picasso

class RandomDogActivity : AppCompatActivity() {
    private lateinit var binding: ActivityRandomDogBinding

    private val viewModel by viewModels<RandomDogViewModel>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityRandomDogBinding.inflate(layoutInflater)
        setContentView(binding.root)

        //Refrescar Imagenes
        binding.imFingerprint.setOnClickListener {
            callRandomDog()
        }

        //Boton Volver
        binding.imBtnBack.setOnClickListener {
            startActivity(Intent(this, MainActivity::class.java))
        }

        binding.dogPhoto.setOnClickListener {
            clickPhoto()
        }

        callRandomDog()
        observer()
    }

    private fun callRandomDog() {
        viewModel.getRandomDog()
    }

    private fun clickPhoto() {
        navigateToImageDetails()
    }

    private fun observer() {
        viewModel.getData().observe(this) { data ->
            when (data) {
                is StateRandomDogViewModel.Success -> {
                    initImage((data.info.message ?: "").toString())
                }
                is StateRandomDogViewModel.Error -> {
                    Toast.makeText(this, "Error", Toast.LENGTH_SHORT).show()
                }
            }
        }

        ////viewModel.selectedImageUrl.observe(this) { imageUrl ->
            ////if (imageUrl != null) {
//                navigateToImageDetails(imageUrl)
            ////}
        ////}
    }

    private fun initImage(value: String) {
//        binding.dogPhoto.setImageURI(value)
        Picasso.get().load(value).into(binding.dogPhoto)
        ImageClass.imageGrid = value

    }

    private fun navigateToImageDetails() {
        val intent = Intent(this, DetailsDogsActivity::class.java)
        startActivity(intent)
    }
}