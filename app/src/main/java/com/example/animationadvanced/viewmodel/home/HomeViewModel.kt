package com.example.animationadvanced.viewmodel.home

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.navigation.NavHostController
import com.example.animationadvanced.di.dispatchers.IoDispatcher
import com.example.animationadvanced.model.home.HomeRepository
import com.example.animationadvanced.model.home.User
import com.example.animationadvanced.view.NavControllerProvider
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(
    private val navControllerProvider: NavControllerProvider,
    private val homeRepository: HomeRepository,
    @IoDispatcher private val ioDispatcher: CoroutineDispatcher
) : ViewModel() {
    private var _user: MutableLiveData<User?> = MutableLiveData(null)
    val user: LiveData<User?> = _user

    private var _isProfileFetching: Boolean = true
    val isProfileFetching = _isProfileFetching

    init {
        fetchUserProfile()
    }

    fun provideNavController(): NavHostController = navControllerProvider.getController()

    private fun fetchUserProfile() {
        viewModelScope.launch(ioDispatcher) {
            homeRepository.getSessionUserProfile().collect {
                _isProfileFetching = true
                _user.postValue(it)
                _isProfileFetching = false
            }
        }
    }
}