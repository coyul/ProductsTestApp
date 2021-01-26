package com.coyul.productstestapp.presentation.fragment

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.coyul.productstestapp.R
import com.coyul.productstestapp.presentation.viewmodel.ProductsListViewModel

/**
 * @author Koenova Yulia
 */
class ProductsListFragment : Fragment() {

    private lateinit var viewModel: ProductsListViewModel

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View {
        return inflater.inflate(R.layout.products_list_fragment, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProvider(this).get(ProductsListViewModel::class.java)
        // TODO: Use the ViewModel
    }

    companion object {
        fun newInstance() = ProductsListFragment()
    }
}