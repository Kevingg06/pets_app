package com.example.myapplication

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.myapplication.databinding.ItemDogBinding
import com.squareup.picasso.Picasso


class DogsAdapter(private val dogList: List<String>) : RecyclerView.Adapter<DogsHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DogsHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_dog,parent,false)
        return  DogsHolder(view)
    }

    override fun getItemCount(): Int {
        return dogList.size
    }

    override fun onBindViewHolder(holder: DogsHolder, position: Int) {
        holder.render(dogList[position])
    }
}

class DogsHolder(view: View) : RecyclerView.ViewHolder(view) {

    private val binding = ItemDogBinding.bind(view)

    fun render(value : String){
        Picasso.get().load(value).into(binding.dogImg)
    }
}

