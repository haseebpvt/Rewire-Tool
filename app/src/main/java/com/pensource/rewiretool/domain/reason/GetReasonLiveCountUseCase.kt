package com.pensource.rewiretool.domain.reason

import androidx.lifecycle.LiveData
import com.pensource.rewiretool.data.reason.ReasonRepository
import javax.inject.Inject

class GetReasonLiveCountUseCase @Inject constructor(
    private val repository: ReasonRepository
) {

    fun execute(): LiveData<Int> {
        return repository.reasonLiveCount()
    }
}