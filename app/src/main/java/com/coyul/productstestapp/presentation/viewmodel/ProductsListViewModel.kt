package com.coyul.productstestapp.presentation.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.coyul.productstestapp.domain.interactor.ProductsInteractor
import com.coyul.productstestapp.domain.model.Element
import com.coyul.productstestapp.presentation.converter.CategoriesToElementsConverter
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import io.reactivex.rxjava3.disposables.CompositeDisposable
import io.reactivex.rxjava3.schedulers.Schedulers
import javax.inject.Inject

/**
 * ViewModel for products list screen
 *
 * @author Koenova Yulia
 */
class ProductsListViewModel @Inject constructor(
    private val productsInteractor: ProductsInteractor,
    private val converter: CategoriesToElementsConverter
) :
    ViewModel() {

    val elementsLiveData: MutableLiveData<List<Element>> = MutableLiveData()
    val progressLiveData: MutableLiveData<Boolean> = MutableLiveData()
    val emptyListLiveData: MutableLiveData<Unit> = MutableLiveData()
    val errorLiveData: MutableLiveData<Unit> = MutableLiveData()

    private val disposable = CompositeDisposable()

    fun load() {
        progressLiveData.postValue(true)
        disposable.add(
            productsInteractor.loadAndSaveCategories()
                .map { converter.convert(it) }
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
                .doFinally { progressLiveData.postValue(false) }
                .subscribe(
                    {
                        if (it.isNotEmpty()) elementsLiveData.postValue(it)
                        else emptyListLiveData.postValue(Unit)
                    },
                    { errorLiveData.postValue(Unit) }
                ))
    }

    override fun onCleared() {
        super.onCleared()
        disposable.dispose()
    }
}