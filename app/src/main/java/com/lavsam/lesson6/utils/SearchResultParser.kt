package com.lavsam.lesson6.utils

import com.lavsam.model.AppState
import com.lavsam.model.Meanings
import com.lavsam.model.SkyengDataModel

fun parseOnlineSearchResults(appState: AppState): AppState =
    AppState.Success(mapResult(appState, true))

private fun mapResult(
    appState: AppState,
    isOnline: Boolean
): List<SkyengDataModel> {
    val newSearchResults = arrayListOf<SkyengDataModel>()
    when (appState) {
        is AppState.Success -> {
            getSuccessResultData(appState, isOnline, newSearchResults)
        }
        else -> {}
    }
    return newSearchResults
}

private fun getSuccessResultData(
    appState: AppState.Success,
    isOnline: Boolean,
    newDataModels: ArrayList<SkyengDataModel>
) {
    val skyengDataModel: List<SkyengDataModel> = appState.data as List<SkyengDataModel>
    if (skyengDataModel.isNotEmpty()) {
        if (isOnline) {
            for (searchResult in skyengDataModel) {
                parseOnlineResult(searchResult, newDataModels)
            }
        } else {
            for (searchResult in skyengDataModel) {
                newDataModels.add(SkyengDataModel(searchResult.text, arrayListOf()))
            }
        }
    }
}

private fun parseOnlineResult(
    skyengDataModel: SkyengDataModel,
    newDataModels: ArrayList<SkyengDataModel>
) {
    if (!skyengDataModel.text.isNullOrBlank() && !skyengDataModel.meanings.isNullOrEmpty()) {
        val newMeanings = arrayListOf<Meanings>()
        for (meaning in skyengDataModel.meanings!!) {
            if (meaning.translation != null && !meaning.translation!!.translation.isNullOrBlank()) {
                newMeanings.add(Meanings(meaning.translation, meaning.imageUrl))
            }
        }
        if (newMeanings.isNotEmpty()) {
            newDataModels.add(SkyengDataModel(skyengDataModel.text, newMeanings))
        }
    }
}

fun convertMeaningsToString(meanings: List<Meanings>): String {
    var meaningsSeparatedByComma = String()
    for ((index, meaning) in meanings.withIndex()) {
        meaningsSeparatedByComma += if (index + 1 != meanings.size) {
            String.format("%s%s", meaning.translation?.translation, ", ")
        } else {
            meaning.translation?.translation
        }
    }
    return meaningsSeparatedByComma
}