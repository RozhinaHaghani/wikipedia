package com.example.wikipedia.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.load.resource.bitmap.RoundedCorners
import com.example.wikipedia.data.ItemPost
import com.example.wikipedia.databinding.ItemRecyclerTrendBinding

class TrendAdapter(private val data: ArrayList<ItemPost>): RecyclerView.Adapter<TrendAdapter.TrendViewHolder>() {
    private lateinit var binding: ItemRecyclerTrendBinding

    inner class TrendViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView){

        fun bindData(itemPost: ItemPost){
            val glide = Glide
                .with(itemView.context)
                .load(itemPost.imageUrl)
                .transform(RoundedCorners(20))
                .into(binding.imgTrendRecyclerView)

            binding.txtTrendTitle.text = itemPost.txtTitle
            binding.txtTrendInfo.text = itemPost.subTitle
            binding.txtTrendInsight.text = itemPost.insight
            binding.txtTrendNumber.text = ( adapterPosition + 1 ).toString()
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TrendViewHolder {
        binding = ItemRecyclerTrendBinding.inflate(LayoutInflater.from(parent.context), parent ,false)
        return TrendViewHolder(binding.root)
    }

    override fun getItemCount(): Int {
        return data.size
    }

    override fun onBindViewHolder(holder: TrendViewHolder, position: Int) {
        holder.bindData(data[position])
    }


}