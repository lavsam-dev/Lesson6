package com.lavsam.historyscreen.presentation.viewModel

import androidx.lifecycle.LiveData
import com.lavsam.core.presentation.viewModel.base.BaseViewModel
import com.lavsam.historyscreen.domain.interactor.HistoryInteractor
import com.lavsam.historyscreen.parseLocalSearchResults
import com.lavsam.model.AppState
import kotlinx.coroutines.launch

class HistoryActivityViewModel(
    private val historyInteractor: HistoryInteractor
) : BaseViewModel<AppState>() {

    private val liveDataForViewToObserve: LiveData<AppState> = _mutableLiveData

    fun subscribe(): LiveData<AppState> = liveDataForViewToObserve

    override fun getData(word: String, isOnline: Boolean) {
        _mutableLiveData.postValue(AppState.Loading(null))
        cancelJob()
        viewModelCoroutineScope.launch { startInteractor(word, isOnline) }
    }

    private suspend fun startInteractor(word: String, isOnline: Boolean) {
        _mutableLiveData.postValue(
            parseLocalSearchResults(
                historyInteractor.getData(
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