package com.namget.logintest.ui.search

import android.view.View
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.namget.logintest.data.model.UserDataList
import com.namget.logintest.data.repository.Repository
import com.namget.logintest.ui.base.BaseViewModel
import com.namget.logintest.util.Logger
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers

class SearchViewModel(
    private val repository: Repository,
    private val logger: Logger
) : BaseViewModel() {

    private val _isLoading = MutableLiveData<Boolean>()
    private val _userDataList = MutableLiveData<UserDataList>()
    private val _UserNameText = MutableLiveData<String>()

    private val _isEndPage = MutableLiveData<Boolean>()
    private val _currentPage = MutableLiveData<Int>()

    val currentPage: LiveData<Int> get() = _currentPage
    val isEndPage: LiveData<Boolean> get() = _isEndPage
    val userDataList: LiveData<UserDataList> get() = _userDataList
    val isLoading: LiveData<Boolean> get() = _isLoading
    var searchedUserName = ""

    private var TOTAL_COUNT = 0
    private val PER_PAGE = 30

    init {
        resetPage()
    }

    fun onNameChanged(s: CharSequence, start: Int, before: Int, count: Int) {
        _UserNameText.value = s.toString()
    }

    fun searchClick(view: View) {
        resetPage()
        searchedUserName = _UserNameText.value ?: ""
        _isLoading.value = true
        searchUserName(searchedUserName, _currentPage.value ?: 1)
    }

    fun resetPage() {
        _currentPage.value = 1
        _isLoading.value = false
        _isEndPage.value = false
    }

    fun searchUserName(userName: String, page: Int) {
        addDisposable(
            repository.getUserList(userName, page)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(::setSearchUserData, logger::e)
        )
    }

    fun loadMore() {
        if (checkLoading() and checkEndPage()) {
            _currentPage.value?.plus(1)
            searchUserName(searchedUserName, currentPage.value!!)
        }
    }

    private fun checkLoading(): Boolean = isLoading.value ?: true
    private fun checkEndPage(): Boolean = _isEndPage.value ?: true

    fun setSearchUserData(userDataList: UserDataList) {
        TOTAL_COUNT = userDataList.totalCount
        var offset = 0
        if (TOTAL_COUNT % PER_PAGE >= 0) {
            offset += 1
        }
        _isEndPage.value = (TOTAL_COUNT / PER_PAGE) + offset >= _currentPage.value!!
        _userDataList.value = userDataList

        println(userDataList)
    }


}