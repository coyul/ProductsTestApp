package com.coyul.productstestapp.presentation.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import com.bumptech.glide.Glide
import com.coyul.productstestapp.R
import com.coyul.productstestapp.databinding.ProductDetailsFragmentBinding
import com.coyul.productstestapp.presentation.model.IdData
import com.coyul.productstestapp.presentation.viewmodel.ProductDetailsViewModel
import dagger.android.support.DaggerFragment
import javax.inject.Inject

/**
 * Fragment for product details
 *
 * @author Koenova Yulia
 */
class ProductDetailsFragment : DaggerFragment() {

    @Inject
    lateinit var viewModelFactory: ViewModelProvider.Factory
    private lateinit var viewModel: ProductDetailsViewModel
    private var nullableBinding: ProductDetailsFragmentBinding? = null
    private val binding get() = nullableBinding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        nullableBinding = ProductDetailsFragmentBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        nullableBinding = null
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        activity?.setTitle(R.string.title_details)
        viewModel =
            ViewModelProvider(this, viewModelFactory).get(ProductDetailsViewModel::class.java)
        observeViewModel()
        arguments?.getSerializable(BUNDLE_ID_DATA_KEY).let {
            val data = it as IdData
            viewModel.loadProduct(data.id, data.categoryId)
        }
    }

    private fun observeViewModel() {
        viewModel.productLiveData.observe(viewLifecycleOwner, {
            binding.productName.text = it.name
            binding.amount.text = it.salePrice.amount.toString()
            binding.currency.text = it.salePrice.currency

            if (it.description.isNotEmpty()) binding.productDescription.text = it.description
            else binding.productDescription.visibility = View.GONE

            Glide
                .with(this)
                .load(it.imageUrl)
                .placeholder(R.drawable.ic_stub_image)
                .into(binding.productImage)
        })
        viewModel.progressLiveData.observe(viewLifecycleOwner, {
            if (it == true) binding.progress.visibility = View.VISIBLE
            else binding.progress.visibility = View.GONE
        })
    }

    companion object {
        private const val BUNDLE_ID_DATA_KEY = "BUNDLE_ID_DATA_KEY"

        fun newInstance(idData: IdData) = ProductDetailsFragment().apply {
            arguments = Bundle().apply {
                putSerializable(BUNDLE_ID_DATA_KEY, idData)
            }
        }
    }
}