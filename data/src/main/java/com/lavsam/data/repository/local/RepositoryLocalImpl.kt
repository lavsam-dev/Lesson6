package com.lavsam.data.repository.local

import com.lavsam.data.dataSource.local.VocabularyDataSourceLocal
import com.lavsam.model.AppState
import com.lavsam.model.VocabularyDataModel

class RepositoryLocalImpl(
    private val vocabularyDataSource: VocabularyDataSourceLocal<List<VocabularyDataModel>>
) : RepositoryLocal<List<VocabularyDataModel>> {

    override suspend fun getData(word: String): List<VocabularyDataModel> =
        vocabularyDataSource.getData(word)

    override suspend fun saveToDB(appState: AppState) {
        vocabularyDataSource.saveToDB(appState)
    }
}