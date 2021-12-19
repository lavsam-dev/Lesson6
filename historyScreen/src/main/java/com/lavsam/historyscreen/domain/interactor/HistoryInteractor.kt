package com.lavsam.historyscreen.domain.interactor

import com.lavsam.core.domain.interactor.Interactor
import com.lavsam.data.repository.local.RepositoryLocal
import com.lavsam.data.repository.remote.RepositoryRemote
import com.lavsam.model.AppState
import com.lavsam.model.VocabularyDataModel

class HistoryInteractor(
    private val repositoryRemote: RepositoryRemote<List<VocabularyDataModel>>,
    private val repositoryLocal: RepositoryLocal<List<VocabularyDataModel>>
) : Interactor<AppState> {

    override suspend fun getData(word: String, fromRemoteSource: Boolean): AppState {
        return AppState.Success(
            if (fromRemoteSource) {
                repositoryRemote
            } else {
                repositoryLocal
            }.getData(word)
        )
    }
}