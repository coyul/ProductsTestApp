package com.coyul.productstestapp.presentation.adapter

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import androidx.viewbinding.ViewBinding
import com.bumptech.glide.Glide
import com.coyul.productstestapp.R
import com.coyul.productstestapp.databinding.CategoryListItemBinding
import com.coyul.productstestapp.databinding.ProductListItemBinding
import com.coyul.productstestapp.domain.model.Category
import com.coyul.productstestapp.domain.model.Element
import com.coyul.productstestapp.domain.model.Product
import com.coyul.productstestapp.presentation.listener.OnItemClickListener

/**
 * ViewHolder abstract entity for main screen products list
 *
 * @author Koenova Yulia
 */
abstract class CategoriesWithProductsViewHolder(binding: ViewBinding) :
    RecyclerView.ViewHolder(binding.root) {
    abstract fun bindView(element: Element, isLastElement: Boolean)
}

/**
 * ViewHolder for category item
 */
class CategoryViewHolder(
    private val binding: CategoryListItemBinding
) : CategoriesWithProductsViewHolder(binding) {

    override fun bindView(element: Element, isLastElement: Boolean) {
        val category = element as Category
        binding.categoryName.text = category.name
    }
}

/**
 * ViewHolder for product item
 */
class ProductViewHolder(
    private val binding: ProductListItemBinding,
    private val clickListener: OnItemClickListener<Element>
) : CategoriesWithProductsViewHolder(binding) {

    override fun bindView(element: Element, isLastElement: Boolean) {
        val product = element as Product
        itemView.setOnClickListener { clickListener.onClick(product) }
        binding.productName.text = product.name
        Glide
            .with(itemView)
            .load(product.imageUrl)
            .centerCrop()
            .placeholder(R.drawable.ic_stub_image)
            .into(binding.productImage)
        binding.divider.visibility = if (isLastElement) View.INVISIBLE else View.VISIBLE
    }
}