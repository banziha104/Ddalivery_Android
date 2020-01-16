package com.iyeongjoon.nicname.ddalivery.ui.fragments.main.home

import android.location.Location
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.iyeongjoon.nicname.core.gps.LocationEvent
import com.iyeongjoon.nicname.data.api.product.ProductApi
import com.iyeongjoon.nicname.data.driver.DataDriver
import com.iyeongjoon.nicname.ddalivery.const.KILO_METER
import com.iyeongjoon.nicname.domain.domain.api.entity.product.Product
import io.reactivex.Observable
import io.reactivex.Single
import org.jetbrains.anko.AnkoLogger

class HomeViewModel(val productApi: ProductApi,
                    val locationEvent: LocationEvent,
                    val dataDriver: DataDriver
) : ViewModel(), AnkoLogger {

    // 요청
    val gridColumns = 2
    private val size = 100
    // 호출될때마다 자동으로 페이지 증가, 0 부터 시작해야함으로 -1로 초기화
    private var page: Int = -1
        get() = field++


    var productModel: Product? = null
        set(value) {
            if (value != null) {
                field?.let {
                    it.data.content.addAll(value.data.content)
                }.let {
                    field = value
                }
            }
        }

    var changedDataStartPoint = size * page

    fun productObserver(location: Location): Observable<Product> = productApi
        .product()
        .getProductsByLocation(size, page, location.latitude,location.longitude, KILO_METER)

}
