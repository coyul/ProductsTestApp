package com.coyul.productstestapp.presentation.activity

import android.os.Bundle
import com.coyul.productstestapp.R
import com.coyul.productstestapp.presentation.fragment.ProductDetailsFragment
import com.coyul.productstestapp.presentation.fragment.ProductsListFragment
import com.coyul.productstestapp.presentation.listener.OnProductItemClickListener
import com.coyul.productstestapp.presentation.model.IdData
import dagger.android.support.DaggerAppCompatActivity

class MainActivity : DaggerAppCompatActivity(), OnProductItemClickListener {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.main_activity)
        val productListFragment = ProductsListFragment.newInstance()
        productListFragment.listener = this
        if (savedInstanceState == null) {
            supportFragmentManager.beginTransaction()
                .replace(R.id.container, productListFragment)
                .commitNow()
        }
    }

    override fun onProductSelected(idData: IdData) {
        supportFragmentManager.beginTransaction()
            .replace(R.id.container, ProductDetailsFragment.newInstance(idData))
            .addToBackStack("details")
            .commit()
    }

    override fun onBackPressed() {
        super.onBackPressed()
    }
}