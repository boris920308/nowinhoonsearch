package hoon.exam.nowinhoonsearch

import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.bumptech.glide.Glide
import hoon.exam.nowinhoonsearch.databinding.ItemHomeSearchResultBinding
import hoon.exam.nowinhoonsearch.network.NaverSearchResponseItemDetail

class HomeSearchResultAdapter() : ListAdapter<NaverSearchResponseItemDetail, HomeSearchResultAdapter.HomeSearchResultAdapterHolder>(
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
        fun bind(item: NaverSearchResponseItemDetail) {
            binding.tvTitle.text = item.title
            binding.tvAuthor.text = item.author
            binding.tvPublisher.text = item.publisher
            binding.tvPrice.text = item.discount.toString()
            binding.tvDescription.text = item.description

            Log.d("hoon92", "HomeSearchResultAdapter, item.image = ${item.image}")

            Glide.with(itemView)
                .load(item.image)
                .into(binding.ivThumbnail)

        }
    }

    companion object {
        val DiffCallback = object : DiffUtil.ItemCallback<NaverSearchResponseItemDetail>() {
            override fun areItemsTheSame(
                oldItem: NaverSearchResponseItemDetail,
                newItem: NaverSearchResponseItemDetail
            ): Boolean {
                return oldItem.title == newItem.title
            }

            override fun areContentsTheSame(
                oldItem: NaverSearchResponseItemDetail,
                newItem: NaverSearchResponseItemDetail
            ): Boolean {
                return oldItem == newItem
            }
        }
    }


}