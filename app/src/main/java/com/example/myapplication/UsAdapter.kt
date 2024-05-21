package com.example.myapplication

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.myapplication.databinding.ItemUsBinding
import com.squareup.picasso.Picasso

class UsAdapter (private val imageList: List<String>) : RecyclerView.Adapter<UsHolder>(){
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): UsHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_us,parent,false )
        return UsHolder(view)
    }

    override fun getItemCount(): Int {
        return imageList.size
    }

    override fun onBindViewHolder(holder: UsHolder, position: Int) {
        holder.render(imageList[position])
    }
}

class UsHolder(val view: View): RecyclerView.ViewHolder(view){

    private val binding = ItemUsBinding.bind(view)

    fun render(value : String){
        Picasso.get().load(value).into(binding.teamPhoto)
    }
}