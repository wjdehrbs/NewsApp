package com.example.newsapp

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.newsapp.databinding.FragmentDetailBinding


class DetailFragment : Fragment() {
    private lateinit var binding: FragmentDetailBinding



    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentDetailBinding.inflate(inflater,container,false)

        val title   = arguments?.getString("TITLE")
        val article  = arguments?.getString("ARTICLE")
        var img =  arguments?.getInt("IMG")

        binding.newsHeadLine.text = title
        binding.newsArticle.text= article
        binding.newsImg1.setImageResource(img!!)

        return binding.root
    }


}