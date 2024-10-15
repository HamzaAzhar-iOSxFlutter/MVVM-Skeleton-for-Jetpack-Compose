package com.example.mvvmskeleton.ViewModel

import android.view.View
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.mvvmskeleton.Model.User
import com.example.mvvmskeleton.Repository
import kotlinx.coroutines.launch

class SkeletonViewModel: ViewModel() {

    var repository: Repository = Repository()
    private val _userData = MutableLiveData<User>()
    private val _isLoading = MutableLiveData<Boolean>(false)
    val userData: LiveData<User> = _userData
    val isLoading : LiveData<Boolean> = _isLoading

    fun fetchUserDetails() {
        _isLoading.postValue(true)
        viewModelScope.launch {
            val userResult = repository.fetchUserDetails()
            _userData.postValue(userResult)
            _isLoading.postValue(false)
        }
    }
}