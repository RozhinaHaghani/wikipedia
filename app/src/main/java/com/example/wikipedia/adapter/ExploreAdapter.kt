package com.example.wikipedia.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.bumptech.glide.Glide
import com.example.wikipedia.data.ItemPost
import com.example.wikipedia.databinding.ItemRecyclerExploreBinding
import java.util.ArrayList

open class ExploreAdapter(private val data: ArrayList<ItemPost>) : RecyclerView.Adapter<ExploreAdapter.ExploreViewHolder>() {
    lateinit var binding: ItemRecyclerExploreBinding


    inner class ExploreViewHolder(itemView: View) : ViewHolder(itemView) {

        fun bindData(itemPost: ItemPost) {

            val glide = Glide
                .with(itemView.context)
                .load(itemPost.imageUrl)
                .into(binding.imageViewItemRecyclerView)

            binding.title1ItemRecyclerView.text = itemPost.txtTitle
            binding.title2ItemRecyclerView.text = itemPost.subTitle
            binding.mainContentItemRecyclerView.text = itemPost.txtDetail
        }


    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ExploreViewHolder {

        //sakhtane binding
        binding = ItemRecyclerExploreBinding.inflate(LayoutInflater.from(parent.context), parent, false)

        return ExploreViewHolder(binding.root)
    }

    override fun getItemCount(): Int {
        return data.size
    }

    override fun onBindViewHolder(holder: ExploreViewHolder, position: Int) {

        holder.bindData(data[position])

    }

}