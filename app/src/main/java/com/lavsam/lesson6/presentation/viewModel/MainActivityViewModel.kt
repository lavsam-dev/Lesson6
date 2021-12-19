package com.lavsam.lesson6.presentation.viewModel

import androidx.lifecycle.LiveData
import com.lavsam.core.presentation.viewModel.base.BaseViewModel
import com.lavsam.lesson6.domain.interactor.MainInteractor
import com.lavsam.lesson6.utils.parseOnlineSearchResults
import com.lavsam.model.AppState
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class MainActivityViewModel(
    private val mainInteractor: MainInteractor
) : BaseViewModel<AppState>() {

    private val liveDataForViewToObserve: LiveData<AppState> = _mutableLiveData

    fun subscribe(): LiveData<AppState> = liveDataForViewToObserve

    override fun getData(word: String, isOnline: Boolean) {
        _mutableLiveData.postValue(AppState.Loading(null))
        cancelJob()
        viewModelCoroutineScope.launch { startInteractor(word, isOnline) }
    }

    private suspend fun startInteractor(word: String, isOnline: Boolean) =
        withContext(Dispatchers.IO) {
            _mutableLiveData.postValue(
                parseOnlineSearchResults(
                    mainInteractor.getData(
                        word,
                        isOnline
                    )
                )
            )
        }

    override fun handleError(error: Throwable) {
        _mutableLiveData.postValue(AppState.Error(error))
    }

    override fun onCleared() {
        _mutableLiveData.postValue(AppState.Success(null))
        super.onCleared()
    }
}