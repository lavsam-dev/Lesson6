package com.lavsam.data.dataSource.local

import com.lavsam.data.convertDataModelSuccessToEntity
import com.lavsam.data.mapHistoryEntityToSearchResult
import com.lavsam.data.room.HistoryDao
import com.lavsam.model.AppState
import com.lavsam.model.VocabularyDataModel

class VocabularyDataSourceLocalImpl(
    private val historyDao: HistoryDao
) : VocabularyDataSourceLocal<List<VocabularyDataModel>> {

    override suspend fun getData(word: String): List<VocabularyDataModel> =
        mapHistoryEntityToSearchResult(historyDao.all())

    override suspend fun saveToDB(appState: AppState) {
        convertDataModelSuccessToEntity(appState)?.let {
            historyDao.insert(it)
        }
    }
}