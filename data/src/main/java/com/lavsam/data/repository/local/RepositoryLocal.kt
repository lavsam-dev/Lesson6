package com.lavsam.data.repository.local

import com.lavsam.data.repository.remote.RepositoryRemote
import com.lavsam.model.AppState

interface RepositoryLocal<T> : RepositoryRemote<T> {
    suspend fun saveToDB(appState: AppState)
}