package com.lavsam.historyscreen.presentation.view.activity

import android.os.Bundle
import com.lavsam.core.presentation.view.activity.base.BaseActivity
import com.lavsam.historyscreen.databinding.ActivityHistoryBinding
import com.lavsam.historyscreen.domain.interactor.HistoryInteractor
import com.lavsam.historyscreen.presentation.adapter.HistoryActivityAdapter
import com.lavsam.historyscreen.presentation.viewModel.HistoryActivityViewModel
import com.lavsam.model.AppState
import com.lavsam.model.VocabularyDataModel
import org.koin.androidx.viewmodel.ext.android.viewModel

class HistoryActivity : BaseActivity<AppState, HistoryInteractor>() {

    private lateinit var binding: ActivityHistoryBinding

    override lateinit var viewModel: HistoryActivityViewModel

    private val adapter: HistoryActivityAdapter by lazy { HistoryActivityAdapter() }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityHistoryBinding.inflate(layoutInflater)
        setContentView(binding.root)

        iniViewModel()
        initViews()
    }

    override fun onResume() {
        super.onResume()
        viewModel.getData("", false)
    }

    override fun setDataToAdapter(data: List<VocabularyDataModel>) {
        adapter.setData(data)
    }

    private fun iniViewModel() {
        if (binding.historyActivityRecyclerview.adapter != null) {
            throw IllegalStateException("The ViewModel should be initialised first")
        }
        val historyViewModel: HistoryActivityViewModel by viewModel()
        viewModel = historyViewModel
        viewModel.subscribe().observe(this@HistoryActivity, { renderData(it) })
    }

    private fun initViews() {
        binding.historyActivityRecyclerview.adapter = adapter
    }
}