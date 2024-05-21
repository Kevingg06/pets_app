package com.example.myapplication

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.myapplication.databinding.ItemGriddogsBinding
import com.squareup.picasso.Picasso


class GridDogsAdapter(private val dogList: List<String>, private val onImageClicked: (String) -> Unit) : RecyclerView.Adapter<GridDogsHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): GridDogsHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_griddogs,parent,false)
        return  GridDogsHolder(view)
    }

    override fun getItemCount(): Int {
        return dogList.size
    }

    override fun onBindViewHolder(holder: GridDogsHolder, position: Int) {
        holder.render(dogList[position], onImageClicked)
    }
}

class GridDogsHolder(view: View) : RecyclerView.ViewHolder(view) {

    private val binding = ItemGriddogsBinding.bind(view)

    fun render(value: String, value1: (String) -> Unit){
        Picasso.get().load(value).into(binding.gridDogImg)

        itemView.setOnClickListener {
            value1(value)
        }
    }
}