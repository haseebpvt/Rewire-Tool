package com.pensource.rewiretool.home

import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.*
import com.pensource.rewiretool.data.db.Reason
import com.pensource.rewiretool.domain.reason.GetRandomReasonUseCase
import com.pensource.rewiretool.domain.reason.GetReasonLiveCountUseCase
import com.pensource.rewiretool.domain.reason.InsertReasonUseCase
import kotlinx.coroutines.launch

class HomeViewModel @ViewModelInject constructor(
    private val getRandomReasonUseCase: GetRandomReasonUseCase,
    private val insertReasonUseCase: InsertReasonUseCase,
    private val getReasonLiveCountUseCase: GetReasonLiveCountUseCase
) : ViewModel() {

    val reasonCount: LiveData<Int> = getReasonLiveCountUseCase.execute()

    private val _reason = MutableLiveData<Reason>()

    val reason: LiveData<Reason> = _reason
    fun loadRandomReason() {
        viewModelScope.launch {
            _reason.value = getRandomReasonUseCase.execute()
        }
    }


    val reasonText = MutableLiveData("")

    fun insertData() {
        viewModelScope.launch {
            reasonText.value?.let { Reason(it) }?.let {
                insertReasonUseCase.execute(it)
            }

            // TODO: Only clear when properly inserted
            clearReasonsEditText()
        }
    }

    private fun clearReasonsEditText() {
        reasonText.value = ""
    }

    val addButtonState = MediatorLiveData<Boolean>().apply {
        addSource(reasonText) {
            this.value = it.isNotBlank()
        }
    }
}