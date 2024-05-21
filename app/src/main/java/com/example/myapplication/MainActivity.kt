package com.example.myapplication

import android.content.Intent
import android.os.Bundle
import android.view.View
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

        call()
        actions()
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
                    initRecyclerView(data.info.message ?: listOf("https://images.dog.ceo/breeds/terrier-welsh/lucy.jpg"))
                }

                is StateViewModel.Loading -> {
                    showLoading()
                }

                is StateViewModel.Error -> {

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

    fun actions(){
        binding.usButton.setOnClickListener {
            val myIntent = Intent(this, UsActivity::class.java)
            startActivity(myIntent)
        }
        binding.dogsButton.setOnClickListener {
            val myIntent = Intent(this, GridDogsActivity::class.java)
            startActivity(myIntent)
        }
        binding.randomButton.setOnClickListener {
            val myIntent = Intent(this, RandomDogActivity::class.java)
            startActivity(myIntent)
        }
        binding.searchButton.setOnClickListener {
            // val myIntent = Intent(this, SearchActivity::class.java)
            // startActivity(myIntent)
        }
    }
}
