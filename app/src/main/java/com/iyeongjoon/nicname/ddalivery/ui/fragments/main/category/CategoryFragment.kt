package com.iyeongjoon.nicname.ddalivery.ui.fragments.main.category

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import com.iyeongjoon.nicname.core.ex.plusAssign
import com.iyeongjoon.nicname.core.rx.fragment.AutoClearedDisposable
import com.iyeongjoon.nicname.ddalivery.R
import com.iyeongjoon.nicname.ddalivery.ui.adapters.recycler.category.CategoryAdapter
import com.iyeongjoon.nicname.ddalivery.ui.adapters.recycler.category.CategoryAdapterViewModel
import dagger.android.support.DaggerFragment
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import kotlinx.android.synthetic.main.fragment_category.*
import org.jetbrains.anko.toast
import javax.inject.Inject

class CategoryFragment : DaggerFragment() {

    @Inject
    lateinit var viewModelFactory: CategoryViewModelFactory
    private lateinit var viewModel: CategoryViewModel
    private val disposables = AutoClearedDisposable(this)
    private val viewDisposables =
        AutoClearedDisposable(lifecycleOwner = this, alwaysClearOnStop = false)


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_category, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        lifecycle += disposables
        lifecycle += viewDisposables
        viewModel = ViewModelProviders.of(this, viewModelFactory)[CategoryViewModel::class.java]
        bind()
    }

    private fun bind() {
        viewDisposables += viewModel
            .categoryApi
            .category()
            .findAll()
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .doOnSubscribe {showProgressBar()}
            .doOnComplete {disapearProgressBar()}
            .subscribe({
                viewModel.dataDriver.category.onNext(it)
                categoryRecyclerView.run {
                    adapter = CategoryAdapter(CategoryAdapterViewModel(activity!!,it))
                    layoutManager = LinearLayoutManager(activity)
                    addItemDecoration(DividerItemDecoration(activity, DividerItemDecoration.VERTICAL))
                }
            }, {
                activity?.toast("데이터 요청에 실패했습니다, 네트워크를 확인해주세요")
                it.printStackTrace()
            })
    }

    private fun showProgressBar() {
        categoryProgressBar.visibility = View.VISIBLE
    }

    private fun disapearProgressBar() {
        categoryProgressBar.visibility = View.INVISIBLE
    }

}
