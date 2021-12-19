package com.lavsam.data.dataSource.local

import com.lavsam.data.dataSource.remote.SkyengDataSourceRemote
import com.lavsam.model.AppState

interface SkyengDataSourceLocal<T> : SkyengDataSourceRemote<T> {
    suspend fun saveToDB(appState: AppState)
}