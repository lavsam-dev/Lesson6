package com.lavsam.data.dataSource.remote

interface SkyengDataSourceRemote<T> {
    suspend fun getData(word: String): T
}