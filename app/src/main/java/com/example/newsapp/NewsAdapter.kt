package com.example.newsapp

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.newsapp.databinding.FragmentTitleBinding


class NewsAdapter(
    private var newsItems: MutableList<NewsItem>,
    private var onItemClickListener: OnItemClickListener
) : RecyclerView.Adapter<NewsAdapter.ViewHolder>() {

    interface OnItemClickListener {
        fun onItemClick(position: Int, title: String, article: String,newsImg:Int)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding = FragmentTitleBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(binding)
    }

    override fun getItemCount(): Int {
        return newsItems.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bindItems(newsItems[position])
    }

    inner class ViewHolder(private val binding: FragmentTitleBinding) :
        RecyclerView.ViewHolder(binding.root) {

        init {
            binding.newsHeadLine.setOnClickListener {
                val position = adapterPosition
                if (position != RecyclerView.NO_POSITION) {
                    val item = newsItems[position]
                    onItemClickListener.onItemClick(position,item.title, item.article,item.imagenews)
                }
            }
        }

        fun bindItems(item: NewsItem) {
            binding.newsHeadLine.text = item.title
            binding.newsImg1.setBackgroundResource(item.imagenews)
        }
    }
}