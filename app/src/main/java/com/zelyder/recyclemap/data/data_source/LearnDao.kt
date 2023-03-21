package com.zelyder.recyclemap.data.data_source

import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Dao
import com.zelyder.recyclemap.domain.model.LearnEntity
import kotlinx.coroutines.flow.Flow

@Dao
interface LearnDao {

    @Query("SELECT * FROM learn")
    fun getList(): Flow<List<LearnEntity>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertLearn(learn: LearnEntity)

    @Delete
    suspend fun deleteLearn(learn: LearnEntity)
}