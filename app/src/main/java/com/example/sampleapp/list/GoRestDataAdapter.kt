package com.example.sampleapp.list

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.paging.PagingDataAdapter
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.sampleapp.data.Data
import com.example.sampleapp.databinding.ListItemLayoutBinding

class GoRestDataAdapter(private val listener: OnItemClickListener) :
    PagingDataAdapter<Data, GoRestDataAdapter.DataViewHolder>(DATA_COMPARATOR) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DataViewHolder {
        val binding = ListItemLayoutBinding.inflate(
            LayoutInflater.from(parent.context),
            parent, false
        )
        return DataViewHolder(binding)
    }

    override fun onBindViewHolder(holder: DataViewHolder, position: Int) {
        val currentItem = getItem(position)
        if (currentItem != null) {
            holder.bind(currentItem)
        }
    }


    inner class DataViewHolder(private val binding: ListItemLayoutBinding) :
        RecyclerView.ViewHolder(binding.root) {
        init {
            binding.root.setOnClickListener {
                val position = bindingAdapterPosition
                if (position != RecyclerView.NO_POSITION) {
                    val item = getItem(position)
                    if (item != null) {
                        listener.onItemClick(item)
                    }
                }
            }
        }

        fun bind(data: Data) {
            binding.apply {
                titleText.text = data.title
                bodyText.text = data.body
            }
        }

    }

    interface OnItemClickListener {
        fun onItemClick(data: Data)
    }

    companion object {
        private val DATA_COMPARATOR = object : DiffUtil.ItemCallback<Data>() {

            override fun areItemsTheSame(oldItem: Data, newItem: Data) =
                oldItem.id == newItem.id

            override fun areContentsTheSame(oldItem: Data, newItem: Data) =
                oldItem == newItem

        }
    }


}