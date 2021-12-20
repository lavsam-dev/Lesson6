package com.lavsam.data.repository.remote

import com.lavsam.data.dataSource.remote.VocabularyDataSourceRemote
import com.lavsam.model.VocabularyDataModel

class RepositoryRemoteImpl(
    private val vocabularyDataSource: VocabularyDataSourceRemote<List<VocabularyDataModel>>
) : RepositoryRemote<List<VocabularyDataModel>> {

    override suspend fun getData(word: String): List<VocabularyDataModel> =
        vocabularyDataSource.getData(word)
}