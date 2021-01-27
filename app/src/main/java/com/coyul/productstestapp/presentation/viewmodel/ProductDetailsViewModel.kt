package com.coyul.productstestapp.presentation.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.coyul.productstestapp.domain.interactor.ProductsInteractor
import com.coyul.productstestapp.domain.model.Product
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import io.reactivex.rxjava3.disposables.CompositeDisposable
import io.reactivex.rxjava3.functions.Consumer
import io.reactivex.rxjava3.schedulers.Schedulers
import javax.inject.Inject

/**
 * ViewModel for product details screen
 *
 * @author Koenova Yulia
 */
class ProductDetailsViewModel @Inject constructor(private val productsInteractor: ProductsInteractor) :
    ViewModel() {

    val productLiveData: MutableLiveData<Product> = MutableLiveData()
    val progressLiveData: MutableLiveData<Boolean> = MutableLiveData()
    private val disposable = CompositeDisposable()

    fun loadProduct(id: Long, categoryId: Long) {
        progressLiveData.postValue(true)
        disposable.add(
            productsInteractor.getProduct(id, categoryId)
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
                .doFinally { progressLiveData.postValue(false) }
                .subscribe(
                    Consumer { productLiveData.postValue(it) }
                )
        )
    }

    override fun onCleared() {
        super.onCleared()
        disposable.dispose()
    }
}