package com.example.myapplication.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.myapplication.R
import com.example.myapplication.databinding.ItemAboutUsBinding
import com.squareup.picasso.Picasso

class AboutUsAdapter(private val listOfImages: List<String>): RecyclerView.Adapter<AboutUsHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): AboutUsHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_about_us,parent,false)
        return AboutUsHolder(view)
    }

    override fun getItemCount(): Int {
        return listOfImages.size
    }

    override fun onBindViewHolder(holder: AboutUsHolder, position: Int) {
        holder.render(listOfImages[position])
    }
}

class  AboutUsHolder(view: View) : RecyclerView.ViewHolder(view){

    private val binding = ItemAboutUsBinding.bind(view)

    fun render(value : String){
        Picasso.get().load(value).into(binding.activityTeamPhoto)
    }

}
