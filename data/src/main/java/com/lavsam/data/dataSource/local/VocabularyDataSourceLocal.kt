package com.lavsam.data.dataSource.local

import com.lavsam.data.dataSource.remote.VocabularyDataSourceRemote
import com.lavsam.model.AppState

interface VocabularyDataSourceLocal<T> : VocabularyDataSourceRemote<T> {
    suspend fun saveToDB(appState: AppState)
}