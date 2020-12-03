package com.pensource.rewiretool.data.db

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query

@Dao
interface ReasonDao {

    @Insert
    fun insertReason(reason: Reason)

    @Query("SELECT * FROM reasons WHERE id == :id")
    fun getReason(id: Int): Reason

    @Query("SELECT COUNT(*) FROM reasons")
    fun totalReasonCount(): Int

    @Query("SELECT COUNT(*) FROM reasons")
    fun totalReasonCountLive(): LiveData<Int>

    @Query("UPDATE reasons SET reason = :text WHERE id == :id")
    fun editReason(id: Int, text: String)
}