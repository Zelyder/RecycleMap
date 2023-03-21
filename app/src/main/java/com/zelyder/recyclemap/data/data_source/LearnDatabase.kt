package com.zelyder.recyclemap.data.data_source

import androidx.room.Database
import androidx.room.RoomDatabase
import com.zelyder.recyclemap.domain.model.LearnEntity

@Database(
    entities = [LearnEntity::class],
    version = 1
)
abstract class LearnDatabase: RoomDatabase() {

    abstract val learnDao: LearnDao

    companion object {
        const val DATABASE_NAME = "learn_db"
    }
}