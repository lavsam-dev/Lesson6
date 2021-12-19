package com.lavsam.data.repository.local

import com.lavsam.data.dataSource.local.SkyengDataSourceLocal
import com.lavsam.model.AppState
import com.lavsam.model.SkyengDataModel

class RepositoryLocalImpl(
    private val skyengDataSource: SkyengDataSourceLocal<List<SkyengDataModel>>
) : RepositoryLocal<List<SkyengDataModel>> {

    override suspend fun getData(word: String): List<SkyengDataModel> =
        skyengDataSource.getData(word)

    override suspend fun saveToDB(appState: AppState) {
        skyengDataSource.saveToDB(appState)
    }
}