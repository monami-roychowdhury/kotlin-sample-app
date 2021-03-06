package com.example.sampleapp.details

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.navArgs
import com.example.sampleapp.R
import com.example.sampleapp.databinding.DetailsFragmentLayoutBinding

class GoRestDetailsFragment : Fragment(R.layout.details_fragment_layout) {
    private val args by navArgs<GoRestDetailsFragmentArgs>()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val binding = DetailsFragmentLayoutBinding.bind(view)
        binding.apply {
            val data = args.data
            titleText.text = data.title
            bodyText.text = data.body
        }

    }
}