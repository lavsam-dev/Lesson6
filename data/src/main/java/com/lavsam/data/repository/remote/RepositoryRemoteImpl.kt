package com.lavsam.data.repository.remote

import com.lavsam.data.dataSource.remote.SkyengDataSourceRemote
import com.lavsam.model.SkyengDataModel

class RepositoryRemoteImpl(
    private val skyengDataSource: SkyengDataSourceRemote<List<SkyengDataModel>>
) : RepositoryRemote<List<SkyengDataModel>> {

    override suspend fun getData(word: String): List<SkyengDataModel> =
        skyengDataSource.getData(word)
}