package com.lavsam.lesson6.di

import androidx.room.Room
import com.lavsam.data.dataSource.local.VocabularyDataSourceLocalImpl
import com.lavsam.data.dataSource.remote.VocabularyDataSourceRemoteImpl
import com.lavsam.data.repository.local.RepositoryLocal
import com.lavsam.data.repository.local.RepositoryLocalImpl
import com.lavsam.data.repository.remote.RepositoryRemote
import com.lavsam.data.repository.remote.RepositoryRemoteImpl
import com.lavsam.data.room.HistoryDataBase
import com.lavsam.historyscreen.domain.interactor.HistoryInteractor
import com.lavsam.historyscreen.presentation.viewModel.HistoryActivityViewModel
import com.lavsam.lesson6.domain.interactor.MainInteractor
import com.lavsam.lesson6.presentation.viewModel.MainActivityViewModel
import com.lavsam.model.VocabularyDataModel
import org.koin.dsl.module

private const val NAME_LOCAL_DB = "HistoryDB"

val application = module {

    single {
        Room.databaseBuilder(
            get(), HistoryDataBase::class.java, NAME_LOCAL_DB
        ).build()
    }

    single { get<HistoryDataBase>().historyDao() }

    single<RepositoryRemote<List<VocabularyDataModel>>> {
        RepositoryRemoteImpl(
            VocabularyDataSourceRemoteImpl()
        )
    }

    single<RepositoryLocal<List<VocabularyDataModel>>> {
        RepositoryLocalImpl(
            VocabularyDataSourceLocalImpl(historyDao = get())
        )
    }
}

val mainScreen = module {
    factory { MainActivityViewModel(mainInteractor = get()) }
    factory { MainInteractor(repositoryRemote = get(), repositoryLocal = get()) }
}

val historyScreen = module {
    factory { HistoryActivityViewModel(historyInteractor = get()) }
    factory { HistoryInteractor(repositoryRemote = get(), repositoryLocal = get()) }
}