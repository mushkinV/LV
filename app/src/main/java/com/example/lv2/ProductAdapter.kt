package com.example.lv2

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.domain.Product
import com.example.lv2.databinding.ItemProductBinding

class ProductAdapter(
    private val data: List<Product>
) : RecyclerView.Adapter<ProductAdapter.ProductViewHolder>() {
    inner class ProductViewHolder(private val binding: ItemProductBinding)
     : RecyclerView.ViewHolder(binding.root) {
        fun bind(item: Product) {
            binding.titleId.text = item.id.toString()
            binding.titleTitle.text = item.title
            binding.titlePrice.text = item.price.toString()

        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ProductViewHolder {
        val binding =
            ItemProductBinding.inflate(LayoutInflater.from(parent.context), parent, false)

        return ProductViewHolder(binding)
    }

    override fun getItemCount(): Int {
        return data.size
    }

    override fun onBindViewHolder(holder: ProductViewHolder, position: Int) {
        holder.bind(data[position])
    }
}
