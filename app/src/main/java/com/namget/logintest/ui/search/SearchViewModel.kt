package com.namget.logintest.ui.search

import android.view.View
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.namget.logintest.data.model.UserDataList
import com.namget.logintest.data.repository.Repository
import com.namget.logintest.ui.base.BaseViewModel
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers

class SearchViewModel(private val repository: Repository) : BaseViewModel() {

    private val _isLoading = MutableLiveData<Boolean>()
    private val _userDataList = MutableLiveData<UserDataList>()
    private val _UserNameText = MutableLiveData<String>()

    private val _isEndPage = MutableLiveData<Boolean>()
    private val _currentPage = MutableLiveData<Int>()

    val currentPage: LiveData<Int> get() = _currentPage
    val isEndPage: LiveData<Boolean> get() = _isEndPage
    val userDataList: LiveData<UserDataList> get() = _userDataList
    val isLoading: LiveData<Boolean> get() = _isLoading

    private val PER_PAGE = 30

    init {
        _currentPage.value = 1
    }

    fun onNameChanged(s: CharSequence, start: Int, before: Int, count: Int) {
        _UserNameText.value = s.toString()
    }

    fun searchClick(view: View) {
        resetPage()
        searchUserName(_UserNameText.value ?: "", _currentPage.value ?: 1)
    }

    fun resetPage() {
        _currentPage.value = 1
    }

    fun searchUserName(userName: String, page: Int) {
        addDisposable(
            repository.getUserList(userName, page)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(
                    {
                        _isEndPage.value = (it.totalCount / PER_PAGE) >= _currentPage.value!!
                        _userDataList.value = it
                        println(it)
                    },
                    {

                    }
                )
        )
    }


}