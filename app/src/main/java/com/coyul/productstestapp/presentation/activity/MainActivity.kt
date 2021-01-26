package com.coyul.productstestapp.presentation.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.coyul.productstestapp.R
import com.coyul.productstestapp.presentation.fragment.ProductsListFragment

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.main_activity)
        if (savedInstanceState == null) {
            supportFragmentManager.beginTransaction()
                    .replace(R.id.container, ProductsListFragment.newInstance())
                    .commitNow()
        }
    }
}