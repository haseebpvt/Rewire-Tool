package com.pensource.rewiretool.domain.reason

import com.pensource.rewiretool.data.db.Reason
import com.pensource.rewiretool.data.reason.ReasonRepository
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.withContext
import javax.inject.Inject

class InsertReasonUseCase @Inject constructor(
    private val reasonRepository: ReasonRepository,
    private val dispatcher: CoroutineDispatcher
) {

    suspend fun execute(reason: Reason): Unit = withContext(dispatcher) {
        reasonRepository.insertReason(reason)
    }
}