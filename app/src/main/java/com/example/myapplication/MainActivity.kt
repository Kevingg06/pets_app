package com.example.myapplication

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.myapplication.databinding.ActivityMainBinding
import com.example.myapplication.viewModel.DogViewModel
import com.example.myapplication.viewModel.StateGridViewModel
import com.example.myapplication.viewModel.StateViewModel


class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    private val viewModel by viewModels<DogViewModel>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        binding.dogsButton.setOnClickListener {
            startActivity(Intent(this, GridDogsActivity::class.java))
        }
        call()
        observer()
    }

    private fun call() {
        viewModel.getDogs()
    }

    private fun observer() {
        viewModel.data.observe(this) { data ->
            when (data) {
                is StateViewModel.Success -> {
                    hideLoading()
                    initRecyclerView(data.info.message ?: listOf())
                }

                is StateViewModel.loading -> {
                    showLoading()
                }

                is StateViewModel.Error -> {
                    Toast.makeText(this, "Error", Toast.LENGTH_SHORT).show()
                }

            }
        }
    }

    private fun showLoading(){
        binding.loadingScreen.visibility = View.VISIBLE
    }

    private fun hideLoading(){
        binding.loadingScreen.visibility = View.GONE
    }

    private fun initRecyclerView(value: List<String>) {
        val adapter = DogsAdapter(value)
        binding.recyclerDogs.adapter = adapter
    }
}
