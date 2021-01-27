package com.coyul.productstestapp.presentation.adapter

import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.coyul.productstestapp.R
import com.coyul.productstestapp.domain.model.Category
import com.coyul.productstestapp.domain.model.Element
import com.coyul.productstestapp.domain.model.Product
import com.coyul.productstestapp.presentation.listener.OnItemClickListener

/**
 * @author Koenova Yulia
 */
abstract class CategoriesWithProductsViewHolder(itemView: View) :
    RecyclerView.ViewHolder(itemView) {
    abstract fun bindView(element: Element, isLastElement: Boolean)
}

class CategoryViewHolder(
    itemView: View
) : CategoriesWithProductsViewHolder(itemView) {

    private val name: TextView = itemView.findViewById(R.id.category_name)

    override fun bindView(element: Element, isLastElement: Boolean) {
        val category = element as Category
        name.text = category.name
    }
}

class ProductViewHolder(
    itemView: View,
    private val clickListener: OnItemClickListener<Element>
) : CategoriesWithProductsViewHolder(itemView) {

    private val name: TextView = itemView.findViewById(R.id.product_name)
    private val image: ImageView = itemView.findViewById(R.id.product_image)
    private val divider: View = itemView.findViewById(R.id.divider)

    override fun bindView(element: Element, isLastElement: Boolean) {
        val product = element as Product
        itemView.setOnClickListener { clickListener.onClick(product) }
        name.text = product.name
        Glide
            .with(itemView)
            .load(product.imageUrl)
            .centerCrop()
            .placeholder(R.drawable.ic_stub_image)
            .into(image)
        divider.visibility = if (isLastElement) View.INVISIBLE else View.VISIBLE
    }
}