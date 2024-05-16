package hoon.exam.nowinhoonsearch

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import hoon.exam.nowinhoonsearch.databinding.ItemHomeSearchResultBinding
import hoon.exam.nowinhoonsearch.network.NaverSearchResponseItem

class HomeSearchResultAdapter() : ListAdapter<NaverSearchResponseItem, HomeSearchResultAdapter.HomeSearchResultAdapterHolder>(
    DiffCallback
) {

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): HomeSearchResultAdapterHolder {
        val binding = ItemHomeSearchResultBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return HomeSearchResultAdapterHolder(binding)
    }

    override fun onBindViewHolder(holder: HomeSearchResultAdapterHolder, position: Int) {
        holder.bind(getItem(position))
    }


    inner class HomeSearchResultAdapterHolder(private val binding: ItemHomeSearchResultBinding) : ViewHolder(binding.root) {
        fun bind(item: NaverSearchResponseItem) {
            binding.tvTitle.text = item.title
        }
    }

    companion object {
        val DiffCallback = object : DiffUtil.ItemCallback<NaverSearchResponseItem>() {
            override fun areItemsTheSame(
                oldItem: NaverSearchResponseItem,
                newItem: NaverSearchResponseItem
            ): Boolean {
                return oldItem.title == newItem.title
            }

            override fun areContentsTheSame(
                oldItem: NaverSearchResponseItem,
                newItem: NaverSearchResponseItem
            ): Boolean {
                return oldItem == newItem
            }
        }
    }


}