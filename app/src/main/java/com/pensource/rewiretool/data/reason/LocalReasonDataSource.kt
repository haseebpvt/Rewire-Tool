package com.pensource.rewiretool.data.reason

import androidx.lifecycle.LiveData
import com.pensource.rewiretool.data.db.Reason
import com.pensource.rewiretool.data.db.ReasonDao
import javax.inject.Inject

interface ReasonDataSource {
    fun getReason(id: Int): Reason
    fun insertReason(reason: Reason)
    fun reasonCount(): Int
    fun reasonLiveCount(): LiveData<Int>
}

class LocalReasonDataSource @Inject constructor(
    private val reasonDao: ReasonDao
) : ReasonDataSource {
    override fun getReason(id: Int): Reason {
        return reasonDao.getReason(id)
    }

    override fun insertReason(reason: Reason) {
        return reasonDao.insertReason(reason)
    }

    override fun reasonCount(): Int {
        return reasonDao.totalReasonCount()
    }

    override fun reasonLiveCount(): LiveData<Int> {
        return reasonDao.totalReasonCountLive()
    }
}