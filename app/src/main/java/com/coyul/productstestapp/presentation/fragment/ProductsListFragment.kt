package com.coyul.productstestapp.presentation.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import com.coyul.productstestapp.R
import com.coyul.productstestapp.databinding.ProductsListFragmentBinding
import com.coyul.productstestapp.domain.model.Element
import com.coyul.productstestapp.domain.model.Product
import com.coyul.productstestapp.presentation.adapter.CategoriesWithProductsAdapter
import com.coyul.productstestapp.presentation.listener.OnItemClickListener
import com.coyul.productstestapp.presentation.listener.OnProductItemClickListener
import com.coyul.productstestapp.presentation.model.IdData
import com.coyul.productstestapp.presentation.viewmodel.ProductsListViewModel
import dagger.android.support.DaggerFragment
import javax.inject.Inject

/**
 * Fragment for products list sorted by categories
 *
 * @author Koenova Yulia
 */
class ProductsListFragment : DaggerFragment(), OnItemClickListener<Element> {

    @Inject
    lateinit var viewModelFactory: ViewModelProvider.Factory
    private lateinit var viewModel: ProductsListViewModel
    private lateinit var adapter: CategoriesWithProductsAdapter
    private var nullableBinding: ProductsListFragmentBinding? = null
    private val binding get() = nullableBinding!!
    lateinit var listener: OnProductItemClickListener

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        nullableBinding = ProductsListFragmentBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        nullableBinding = null
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        activity?.setTitle(R.string.app_name)
        adapter = CategoriesWithProductsAdapter(this)
        binding.categoriesProductsRecyclerView.adapter = adapter
        viewModel = ViewModelProvider(this, viewModelFactory).get(ProductsListViewModel::class.java)
        observeViewModel()
        viewModel.load()
    }

    override fun onClick(element: Element) {
        listener.onProductSelected(IdData(element.id, (element as Product).categoryId))
    }

    private fun observeViewModel() {
        viewModel.elementsLiveData.observe(viewLifecycleOwner, {
            adapter.submitList(it)
        })
        viewModel.progressLiveData.observe(viewLifecycleOwner, {
            if (it == true) binding.progress.visibility = View.VISIBLE
            else binding.progress.visibility = View.GONE
        })
        viewModel.errorLiveData.observe(viewLifecycleOwner, {
            binding.stubText.visibility = View.VISIBLE
            binding.stubText.setText(R.string.error_text)
        })
        viewModel.emptyListLiveData.observe(viewLifecycleOwner, {
            binding.stubText.visibility = View.VISIBLE
            binding.stubText.setText(R.string.stub_text)
        })
    }

    companion object {
        fun newInstance() = ProductsListFragment()
    }
}