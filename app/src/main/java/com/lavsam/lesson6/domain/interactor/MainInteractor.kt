package com.lavsam.lesson6.domain.interactor

import com.lavsam.core.domain.interactor.Interactor
import com.lavsam.data.repository.local.RepositoryLocal
import com.lavsam.data.repository.remote.RepositoryRemote
import com.lavsam.model.AppState
import com.lavsam.model.VocabularyDataModel

class MainInteractor(
    private val repositoryRemote: RepositoryRemote<List<VocabularyDataModel>>,
    private val repositoryLocal: RepositoryLocal<List<VocabularyDataModel>>
) : Interactor<AppState> {

    override suspend fun getData(word: String, fromRemoteSource: Boolean): AppState {
        val appState: AppState
        if (fromRemoteSource) {
            appState = AppState.Success(repositoryRemote.getData(word))
            repositoryLocal.saveToDB(appState)
        } else {
            appState = AppState.Success(repositoryLocal.getData(word))
        }
        return appState
    }
}