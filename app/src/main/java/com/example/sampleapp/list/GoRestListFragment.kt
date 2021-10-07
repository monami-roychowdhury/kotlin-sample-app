package com.example.sampleapp.list

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.example.sampleapp.R
import com.example.sampleapp.data.Data
import com.example.sampleapp.databinding.ListFragmentLayoutBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class GoRestListFragment : Fragment(R.layout.list_fragment_layout),
    GoRestDataAdapter.OnItemClickListener {

    private val viewModel by viewModels<GoRestDataViewModel>()
    private var _binding: ListFragmentLayoutBinding? = null
    private val binding get() = _binding!!

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        _binding = ListFragmentLayoutBinding.bind(view)
        val adapter = GoRestDataAdapter(this)
        binding.apply {
            recyclerView.setHasFixedSize(true)
            recyclerView.itemAnimator = null
            recyclerView.adapter = adapter
        }
        viewModel.posts.observe(viewLifecycleOwner) {
            adapter.submitData(viewLifecycleOwner.lifecycle, it)
        }
    }


    override fun onItemClick(data: Data) {
        val action = GoRestListFragmentDirections.actionGoRestListFragmentToGoRestDetailsFragment(data)
        findNavController().navigate(action)
    }
}