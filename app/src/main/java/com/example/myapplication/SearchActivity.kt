package com.example.myapplication

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.SearchView
import com.example.myapplication.databinding.ActivitySearchBinding
import com.example.myapplication.viewModel.SearchDogViewModel
import com.example.myapplication.viewModel.StateSearchDogViewModel
import com.squareup.picasso.Picasso

class SearchActivity : AppCompatActivity() {

    private lateinit var binding: ActivitySearchBinding
    private val viewModel by viewModels<SearchDogViewModel>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySearchBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // Boton Volver
        binding.imBtnBack.setOnClickListener {
            startActivity(Intent(this, MainActivity::class.java))
        }

        buscadorDog()
        observer()
    }

    private fun buscadorDog() {
        binding.searchView.setOnQueryTextListener(object : SearchView.OnQueryTextListener {
            override fun onQueryTextSubmit(query: String?): Boolean {
                if (!query.isNullOrEmpty()) {
                    viewModel.getSearchDogs(query)
                }
                return false
            }

            override fun onQueryTextChange(newText: String?): Boolean {
                return true
            }
        })
    }

    private fun observer() {
        viewModel.getData().observe(this) { data ->
            when (data) {
                is StateSearchDogViewModel.Success -> {
                    initImage((data.info.message ?: "").toString())
                }
                is StateSearchDogViewModel.Error -> {
                    Toast.makeText(this, "Error", Toast.LENGTH_SHORT).show()
                }
            }
        }

        viewModel.selectedImageUrl.observe(this) { imageUrl ->
            if (imageUrl != null) {
                // navigateToImageDetails(imageUrl)
            }
        }
    }

    private fun initImage(value: String) {
        Picasso.get().load(value).into(binding.dogPhoto)
    }
}