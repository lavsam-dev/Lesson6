package com.lavsam.data

import com.lavsam.data.room.HistoryEntity
import com.lavsam.model.AppState
import com.lavsam.model.SkyengDataModel

fun mapHistoryEntityToSearchResult(list: List<HistoryEntity>): List<SkyengDataModel> {
    val searchResult = ArrayList<SkyengDataModel>()
    if (!list.isNullOrEmpty()) {
        for (entity in list) {
            searchResult.add(SkyengDataModel(entity.word, null))
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