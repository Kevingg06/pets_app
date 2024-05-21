package com.example.myapplication.activity

import android.content.Intent
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.myapplication.R
import com.example.myapplication.adapter.AboutUsAdapter
import com.example.myapplication.adapter.UsAdapter
import com.example.myapplication.databinding.ActivityUsBinding

class UsActivity : AppCompatActivity() {
    private lateinit var binding: ActivityUsBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        binding = ActivityUsBinding.inflate(layoutInflater)
        setContentView(binding.root)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val imageList = listOf(
            "https://minio.api.abexacloud.com/api/Archivo/verImagen?NombreCarpeta=kotlin-app&NombreImagen=kevin-p",
            "https://minio.api.abexacloud.com/api/Archivo/verImagen?NombreCarpeta=kotlin-app&NombreImagen=reinier-p",
            "https://minio.api.abexacloud.com/api/Archivo/verImagen?NombreCarpeta=kotlin-app&NombreImagen=jhosep-p"
        )

        val imageListHobbie = listOf(
            "https://minio.api.abexacloud.com/api/Archivo/verImagen?NombreCarpeta=kotlin-app&NombreImagen=kevin-h",
            "https://minio.api.abexacloud.com/api/Archivo/verImagen?NombreCarpeta=kotlin-app&NombreImagen=reinier-h",
            "https://minio.api.abexacloud.com/api/Archivo/verImagen?NombreCarpeta=kotlin-app&NombreImagen=jhosep-h"
        )

        actions()
        initRecyclerView(imageList)
        initRecyclerView2(imageListHobbie)
    }

    private fun actions() {
        binding.goBack.setOnClickListener {
            val myIntent = Intent(this, MainActivity::class.java)
            startActivity(myIntent)
        }
    }

    private fun initRecyclerView(list: List<String>) {
        val adapter = AboutUsAdapter(list)
        binding.aboutUsRv.adapter = adapter
    }

    private fun initRecyclerView2(list: List<String>) {
        val adapter = UsAdapter(list)
        binding.usRv.adapter = adapter
    }
}
