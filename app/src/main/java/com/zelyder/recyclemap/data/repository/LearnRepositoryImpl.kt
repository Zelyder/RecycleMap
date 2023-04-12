package com.zelyder.recyclemap.data.repository

import android.content.Context
import com.google.gson.Gson
import com.zelyder.recyclemap.data.data_source.LearnDao
import com.zelyder.recyclemap.domain.model.LearnEntity
import com.zelyder.recyclemap.domain.model.RecycleCode
import com.zelyder.recyclemap.domain.model.RecycleCodesList
import com.zelyder.recyclemap.domain.repository.LearnRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.withContext
import java.io.InputStream

class LearnRepositoryImpl(
    private val context: Context
) : LearnRepository {


    override suspend fun getCodesList(id: Int): List<RecycleCode> {
        val jsonString = loadJson("codes_$id.json")
        if (jsonString != null) {
            val codes = Gson().fromJson(jsonString, RecycleCodesList::class.java)
            return codes.data
        }
        return emptyList()
    }



    private suspend fun loadJson(fileName: String): String? = withContext(Dispatchers.IO) {
        var input: InputStream? = null
        var jsonString: String? = null
        try {
            input = context.assets.open("codes/$fileName")
            val size = input.available()
            val buffer = ByteArray(size)
            input.read(buffer)
            jsonString= String(buffer)
        } catch (ex: Exception) {
            ex.printStackTrace()
        } finally {
            input?.close()
        }
        jsonString
    }
}