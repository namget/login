package com.namget.logintest.ui.search

import android.os.Bundle
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.namget.logintest.R
import com.namget.logintest.databinding.ActivitySearchBinding
import com.namget.logintest.ui.base.BaseActivity
import com.namget.logintest.ui.search.adapter.SearchAdapter
import org.koin.android.ext.android.inject

class SearchActivity : BaseActivity<ActivitySearchBinding>() {
    override val layoutId: Int
        get() = R.layout.activity_search

    private val searchViewModelFactory: SearchViewModelFactory by inject()
    private val searchViewModel: SearchViewModel by lazy {
        ViewModelProviders.of(this, searchViewModelFactory).get(SearchViewModel::class.java)
    }
    private lateinit var searchAdapter: SearchAdapter


    override fun init() {
        searchAdapter = SearchAdapter(arrayListOf())
        binding.recyclerView.apply {
            this.layoutManager = LinearLayoutManager(this@SearchActivity)
            this.adapter = searchAdapter

            this.addOnScrollListener(object : RecyclerView.OnScrollListener() {
                override fun onScrolled(recyclerView: RecyclerView, dx: Int, dy: Int) {
                    super.onScrolled(recyclerView, dx, dy)
                    //최상단
                    if (!recyclerView.canScrollVertically(-1)) {
                    }
                    //최하단
                    else if (!recyclerView.canScrollVertically(1)) {
                        if (recyclerView.adapter?.itemCount != 0)
                            searchViewModel.loadMore()
                    } else {
                    }
                }
            })
        }


    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        initViewModel()
    }

    fun initViewModel() {
        binding.viewmodel = searchViewModel
        binding.lifecycleOwner = this
        searchViewModel.userDataList.observe(this, Observer {
            if (!(searchViewModel.isEndPage.value ?: true)) {
                if (searchAdapter.itemCount == 0) {
                    searchAdapter.setItem(it.UserList)
                } else {
                    searchAdapter.addItem(it.UserList)
                }
            }
        })

    }


}