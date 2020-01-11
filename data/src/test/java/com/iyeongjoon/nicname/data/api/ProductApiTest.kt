package com.iyeongjoon.nicname.data.api

import com.iyeongjoon.nicname.data.api.product.ProductApi
import org.junit.Test
import java.util.concurrent.TimeUnit


class ProductApiTest {
    val productApi = ProductApi()

    @Test
    fun product() {
        productApi
            .product()
            .getProducts(100, 0)
            .doOnNext{ print(it.data.content)}
            .test()
            .awaitDone(3, TimeUnit.SECONDS)
            .assertValue { it.code == "OK" }
            .assertComplete()
    }


}