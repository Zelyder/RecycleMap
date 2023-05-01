package com.zelyder.recyclemap.domain.util

import java.text.SimpleDateFormat
import java.util.*

object Utils {
    fun timeFormatFromStringToMillis(date: String): Long {

        var setYear = false

        val pattern = when(defineDateFormat(date = date)) {
            DateFormat.ShortDateWithoutTime -> "dd.MM.yyyy"
            DateFormat.FullDateWithoutYear -> {
                setYear = true
                "dd MMMM, HH:mm"
            }
            DateFormat.Undefined -> ""
        }

        if (pattern.isBlank()) {
            return 0L
        }
        val dateFormat = SimpleDateFormat(pattern, Locale.getDefault())



        return try {
            val dateParsed = dateFormat.parse(date) ?: Date()
            if (setYear){
                val calendar = Calendar.getInstance() // создаем объект Calendar для работы с датой
                val currentYear = calendar.get(Calendar.YEAR)
                calendar.time = dateParsed // устанавливаем дату из объекта Date
                calendar.set(Calendar.YEAR, currentYear) // устанавливаем год, например, 2024
                calendar.time.time // получаем новый объект Date с измененной датой
            }else {
                dateParsed.time
            }
        } catch (ex: Exception) {
            0L
        }


    }
    fun defineDateFormat(date: String): DateFormat {
        val regexShortDateWithYear = Regex("\\d{2}\\.\\d{2}\\.\\d{4}")
        val regexFullDateWithoutYear = Regex("\\d{1,2}\\s+[а-яА-Я]+\\s*,\\s*\\d{1,2}:\\d{2}")

        return when{
            regexShortDateWithYear.matches(date) -> DateFormat.ShortDateWithoutTime
            regexFullDateWithoutYear.matches(date) ->DateFormat.FullDateWithoutYear
            else ->DateFormat.Undefined
        }
    }

}

enum class DateFormat {
    ShortDateWithoutTime,
    FullDateWithoutYear,
    Undefined
}