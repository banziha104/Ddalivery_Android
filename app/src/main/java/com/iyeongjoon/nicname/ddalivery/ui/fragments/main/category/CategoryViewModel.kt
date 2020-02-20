package com.iyeongjoon.nicname.ddalivery.ui.fragments.main.category

import androidx.lifecycle.ViewModel
import com.iyeongjoon.nicname.core.gps.LocationEvent
import com.iyeongjoon.nicname.data.api.category.CategoryApi
import com.iyeongjoon.nicname.data.driver.DataDriver
import com.iyeongjoon.nicname.domain.domain.api.entity.category.Category
import io.reactivex.Observable
import io.reactivex.schedulers.Schedulers

class CategoryViewModel(
    val locationEvent: LocationEvent,
    val categoryApi: CategoryApi,
    val dataDriver: DataDriver
) : ViewModel() {
    val findAllCategory : Observable<Category> = categoryApi
    .category()
    .findAll()
    .subscribeOn(Schedulers.io())
}
