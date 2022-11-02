package com.example.innovecstesttask.mvi_mvvm

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.example.innovecstesttask.data.repository.ActionConfigRepository
import com.example.innovecstesttask.data.result_handling.*
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class MainViewModel constructor(private val dataManager: ConfigurationDataManager) : BaseViewModel() {

    private var mutableLiveDataState: MutableLiveData<BaseState> = MutableLiveData()
    val viewState: LiveData<BaseState> = mutableLiveDataState

//    override fun getDataManager() = ConfigurationDataManager()

    override fun obtainIntent(intent: BaseUserIntent) {
        mutableLiveDataState.value = BaseState.LoadingState
        viewModelScope.launch {
            mutableLiveDataState.let {
                it.value = BaseState.LoadingState

                val resultData = withContext(Dispatchers.IO) {
                    ActionConfigRepository().fetchDataResult()
                }

                withContext(Dispatchers.Main) {
                    when (resultData) {
                        is SuccessDataResult -> {
                            val state =
                                dataManager.getHandledData(resultData.data).type.convertStringTypeIntoStateFormat()
                            mutableLiveDataState.value = state
                        }
                        is ErrorDataResult -> {
                            mutableLiveDataState.value = BaseState.ErrorState
                        }
                    }


                }
            }
        }
    }

}