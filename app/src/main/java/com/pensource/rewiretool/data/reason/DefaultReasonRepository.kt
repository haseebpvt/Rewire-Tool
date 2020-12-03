package com.pensource.rewiretool.data.reason

import androidx.lifecycle.LiveData
import com.pensource.rewiretool.data.db.Reason
import javax.inject.Inject

interface ReasonRepository {
    fun getReason(id: Int): Reason
    fun insertReason(reason: Reason)
    fun reasonCount(): Int
    fun reasonLiveCount(): LiveData<Int>
}

class DefaultReasonRepository @Inject constructor(
    private val reasonDataSource: ReasonDataSource
) : ReasonRepository {
    override fun getReason(id: Int): Reason = reasonDataSource.getReason(id)

    override fun insertReason(reason: Reason) = reasonDataSource.insertReason(reason)

    override fun reasonCount(): Int = reasonDataSource.reasonCount()

    override fun reasonLiveCount(): LiveData<Int> = reasonDataSource.reasonLiveCount()
}