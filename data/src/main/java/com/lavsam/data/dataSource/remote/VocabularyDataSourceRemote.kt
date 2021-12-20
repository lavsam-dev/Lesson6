package com.lavsam.data.dataSource.remote

interface VocabularyDataSourceRemote<T> {
    suspend fun getData(word: String): T
}