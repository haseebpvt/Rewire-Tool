package com.pensource.rewiretool.domain.reason

import android.util.Log
import com.pensource.rewiretool.data.db.Reason
import com.pensource.rewiretool.data.reason.ReasonRepository
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.withContext
import javax.inject.Inject
import kotlin.random.Random

class GetRandomReasonUseCase @Inject constructor(
    private val reasonRepository: ReasonRepository,
    private val dispatcher: CoroutineDispatcher
) {

    suspend fun execute(): Reason = withContext(dispatcher) {
        val totalReasonCount: Int = reasonRepository.reasonCount()

        if (totalReasonCount == 0) {
            return@withContext Reason("START BY ADDING A REASON")
        }

        val randomNumber: Int = Random.nextInt(1, totalReasonCount + 1)
        Log.d("custom_log", "total count: $totalReasonCount, random number: $randomNumber")
        return@withContext reasonRepository.getReason(randomNumber)
    }
}