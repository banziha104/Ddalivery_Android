package com.iyeongjoon.nicname.ddalivery.ui.fragments.main.home

import androidx.lifecycle.ViewModelProviders
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.GridLayoutManager
import com.iyeongjoon.nicname.core.ex.plusAssign
import com.iyeongjoon.nicname.core.rx.fragment.AutoClearedDisposable

import com.iyeongjoon.nicname.ddalivery.R
import com.iyeongjoon.nicname.ddalivery.ui.adapters.recycler.home.HomeAdapter
import com.iyeongjoon.nicname.ddalivery.ui.adapters.recycler.home.HomeAdapterViewModel
import com.iyeongjoon.nicname.ddalivery.ex.endScrollEvent
import dagger.android.support.DaggerFragment
import io.reactivex.android.schedulers.AndroidSchedulers
import kotlinx.android.synthetic.main.fragment_home.*
import org.jetbrains.anko.AnkoLogger
import org.jetbrains.anko.info
import org.jetbrains.anko.toast
import javax.inject.Inject

class HomeFragment : DaggerFragment(), AnkoLogger {

    @Inject
    lateinit var viewModelFactory: HomeViewModelFactory
    private lateinit var viewModel: HomeViewModel
    private val disposables = AutoClearedDisposable(this)
    private val viewDisposables =
        AutoClearedDisposable(lifecycleOwner = this, alwaysClearOnStop = false)
    lateinit var homeAdapter: HomeAdapter


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_home, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        info { "액티비티" }
        lifecycle += disposables
        lifecycle += viewDisposables
        viewModel = ViewModelProviders.of(this, viewModelFactory)[HomeViewModel::class.java]
        bind()
    }

    private fun bind() {

        viewDisposables += viewModel
            .locationEvent
            .getLocationObserver()
            .subscribe({ location ->
                viewDisposables += viewModel
                    .productObserver(location)
                    .observeOn(AndroidSchedulers.mainThread())
                    .doOnSubscribe { showProgressBar() }
                    .doOnComplete { disapearProgressBar() }
                    .subscribe({ product ->
                        viewModel.dataDriver.product.onNext(product)
                        info { "사이즈 ${product.data.content.size}" }
                        homeAdapter = HomeAdapter(HomeAdapterViewModel(product, context!!))
                        homeRecyclerView.apply {
                            adapter = homeAdapter
                            layoutManager = GridLayoutManager(context, viewModel.gridColumns)
                            disposables += endScrollEvent().subscribe { if (it) refreshRecyclerView() }
                        }
                    }, {
                        it.printStackTrace()
                    })
            }, {
                activity?.toast("데이터 요청에 실패했습니다, 네트워크를 확인해주세요")
                it.printStackTrace()
            })

    }

    private fun refreshRecyclerView() {
//        viewDisposables += viewModel
//            .locationEvent
//            .getLocationObserver()
//            .subscribe({
//                viewDisposables += viewModel.productObserver(it)
//                    .observeOn(AndroidSchedulers.mainThread())
//                    .doOnSubscribe { showProgressBar() }
//                    .doOnComplete { disapearProgressBar() }
//                    .subscribe({product ->
//                        viewModel.productModel = product
//                        info { "${product.data.content.size} 입니다" }
//                        viewModel.productModel?.let {
//                            homeRecyclerView.apply {
//                                info { "${it.data.size} 이더라" }
//                                homeAdapter =  HomeAdapter(HomeAdapterViewModel(it, context!!))
//                                homeAdapter.notifyDataSetChanged()
////                                homeAdapter.notifyItemRangeChanged(viewModel.changedDataStartPoint,it.data.content.size -1 )
//                            }
//                        }
//                    }, {
//                        it.printStackTrace()
//                    })
//            },{
//                it.printStackTrace()
//            })


//        homeRecyclerView.adapter = HomeAdapter(Homeada)
    }

    private fun showProgressBar() {
        homeProgressBar.visibility = View.VISIBLE
    }

    private fun disapearProgressBar() {
        homeProgressBar.visibility = View.INVISIBLE
    }


}
