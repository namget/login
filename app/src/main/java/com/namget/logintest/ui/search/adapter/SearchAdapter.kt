package com.namget.logintest.ui.search.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import com.namget.logintest.R
import com.namget.logintest.data.model.UserData
import com.namget.logintest.databinding.ItemSearchUserBinding
import com.namget.logintest.ui.base.LifecycleRecyclerAdapter
import com.namget.logintest.ui.base.LifecycleViewHolder
import com.namget.logintest.ui.search.SearchItemViewModel

class SearchAdapter(var dataList: ArrayList<UserData>) : LifecycleRecyclerAdapter<LifecycleViewHolder>() {


    inner class SearchViewHolder(val item: ItemSearchUserBinding) : LifecycleViewHolder(item.root) {
        fun setViewModel(searchItemViewModel: SearchItemViewModel) {
            item.viewmodel = searchItemViewModel
        }
    }

    fun clear() {
        dataList.clear()
    }

    fun addItem(list: ArrayList<UserData>) {
        val before = dataList.size
        this.dataList.addAll(list)
        notifyItemRangeChanged(before, list.size)
    }

    fun setItem(list: ArrayList<UserData>) {
        clear()
        this.dataList = list
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): LifecycleViewHolder {
        val item: ItemSearchUserBinding =
            DataBindingUtil.inflate(LayoutInflater.from(parent.context), R.layout.item_search_user, parent, false)
        return SearchViewHolder(item)
    }

    override fun getItemCount() = dataList.size
    override fun onBindViewHolder(holder: LifecycleViewHolder, position: Int) {
        val searchItemViewModel = SearchItemViewModel(dataList[position])
        (holder as SearchViewHolder).setViewModel(searchItemViewModel)
    }
}