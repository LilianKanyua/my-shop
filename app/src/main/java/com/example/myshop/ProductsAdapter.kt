package com.example.myshop

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.myshop.databinding.ProductsListBinding
import com.squareup.picasso.Picasso
import jp.wasabeef.picasso.transformations.CropCircleTransformation

class ProductsAdapter (var productsList: List<Procucts>):RecyclerView.Adapter<ProductsAdapter.ProductsViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ProductsViewHolder {
        var binding =
            ProductsListBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ProductsViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ProductsViewHolder, position: Int) {
        var currentProducts = productsList.get(position)
        var binding = holder.binding
//        binding.ivProducts.text = currentProcucts.thumbnail.toString()
        binding.tvId.text = currentProducts.id.toString()
        binding.tvDesc.text = currentProducts.description.toString()
        binding.tvRating.text = currentProducts.rating.toString()
        binding.tvPrice.text = currentProducts.price.toString()
        binding.tvCategory.text = currentProducts.category.toString()
        binding.tvTitle.text = currentProducts.title.toString()
        binding.tvStock.text = currentProducts.stock.toString()


        Picasso
            .get()
            .load(currentProducts.thumbnail)
            .transform(CropCircleTransformation())
            .into(binding.ivProducts)


    }

    override fun getItemCount(): Int {
        return productsList.size
    }

    //}
    class ProductsViewHolder(var binding: ProductsListBinding) :
        RecyclerView.ViewHolder(binding.root) {

    }
}