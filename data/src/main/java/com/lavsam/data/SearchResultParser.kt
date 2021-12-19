package com.lavsam.data

import com.lavsam.data.room.HistoryEntity
import com.lavsam.model.AppState
import com.lavsam.model.VocabularyDataModel

fun mapHistoryEntityToSearchResult(list: List<HistoryEntity>): List<VocabularyDataModel> {
    val searchResult = ArrayList<VocabularyDataModel>()
    if (!list.isNullOrEmpty()) {
        for (entity in list) {
            searchResult.add(VocabularyDataModel(entity.word, null))
        }
    }
    return searchResult
}

fun convertDataModelSuccessToEntity(appState: AppState): HistoryEntity? {
    return when (appState) {
        is AppState.Success -> {
            val searchResult = appState.data
            if (searchResult.isNullOrEmpty() || searchResult[0].text.isNullOrEmpty()) {
                null
            } else {
                HistoryEntity(searchResult[0].text!!, null)
            }
        }
        else -> null
    }
}