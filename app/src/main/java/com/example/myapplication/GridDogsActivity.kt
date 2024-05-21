package com.example.myapplication

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.GridLayoutManager
import com.example.myapplication.databinding.ActivityGriddogsBinding
import com.example.myapplication.viewModel.GridDogViewModel
import com.example.myapplication.viewModel.StateGridViewModel

class GridDogsActivity : AppCompatActivity() {
    private lateinit var binding: ActivityGriddogsBinding

    private val viewModel by viewModels<GridDogViewModel>()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityGriddogsBinding.inflate(layoutInflater)
        setContentView(binding.root)

        //Refrescar Imagenes
        binding.imFingerprint.setOnClickListener {
            callGrid()
        }

        //Boton Volver
        binding.imBtnBack.setOnClickListener {
            startActivity(Intent(this, MainActivity::class.java))
        }

        //Cargar por vez primera las imagenes del RecyclerView
        callGrid()

        //Observer para actualizar el Adapter con las nuevas imagenes del RecyclerView
        observer()
    }

    private fun callGrid() {
        viewModel.getGridDogs()
    }
    private fun observer() {
        viewModel.getData().observe(this) { data ->
            when (data) {
                is StateGridViewModel.Success -> {
                    initRecyclerView(data.info.message ?: listOf())
                }
                is StateGridViewModel.Error -> {
                    Toast.makeText(this, "Error", Toast.LENGTH_SHORT).show()
                }
            }
        }

        viewModel.getImage().observe(this) {
                navigateToImageDetails()
        }
    }

    private fun initRecyclerView(value: List<String>) {
        binding.recyclerGridDogs.layoutManager = GridLayoutManager(this, 3)
        val adapter = GridDogsAdapter(value, viewModel::onImageClicked)
        binding.recyclerGridDogs.adapter = adapter

    }

    //private fun navigateToImageDetails(imageUrl: String) {
    private fun navigateToImageDetails() {
        val intent = Intent(this, DetailsDogsActivity::class.java)
        startActivity(intent)
    }

}