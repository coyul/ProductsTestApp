package com.coyul.productstestapp.presentation.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.coyul.productstestapp.R
import com.coyul.productstestapp.domain.model.Category
import com.coyul.productstestapp.domain.model.Element
import com.coyul.productstestapp.presentation.listener.OnItemClickListener

/**
 * Адаптер для избранного - в списке под [Category] располагаются кликабельные [Product]
 *
 * @author Koenova Yulia
 */
class CategoriesWithProductsAdapter(
    private val clickListener: OnItemClickListener<Element>
) :
    RecyclerView.Adapter<CategoriesWithProductsViewHolder>() {

    var elements: List<Element> = emptyList()

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): CategoriesWithProductsViewHolder {
        return when (ItemViewType.values()[viewType]) {
            ItemViewType.CATEGORY -> {
                val view = LayoutInflater
                    .from(parent.context)
                    .inflate(R.layout.category_list_item, parent, false)
                CategoryViewHolder(
                    view
                )
            }
            ItemViewType.PRODUCT -> {
                val view = LayoutInflater
                    .from(parent.context)
                    .inflate(R.layout.product_list_item, parent, false)
                ProductViewHolder(
                    view,
                    clickListener
                )
            }
        }
    }

    override fun getItemCount(): Int = elements.size

    override fun onBindViewHolder(holder: CategoriesWithProductsViewHolder, position: Int) {
        holder.bindView(elements[position], isLastProduct(position))
    }


    fun submitList(elements: List<Element>) {
        this.elements = elements
        notifyDataSetChanged()
    }

    override fun getItemViewType(position: Int): Int {
        val element = elements[position]
        return if (element is Category) ItemViewType.CATEGORY.ordinal
        else ItemViewType.PRODUCT.ordinal
    }

    private fun isLastProduct(position: Int): Boolean {
        return itemCount - 1 == position || (itemCount > position + 1 && elements[position + 1] is Category)
    }
}
