package com.example.madlevel5task2.database

import androidx.room.TypeConverter
import java.util.*

class Converters {

    @TypeConverter
    fun fromDate(date: Date): Long {
        return date.time.toLong()
    }

    @TypeConverter
    fun toDate(date: Long): Date {
        return Date(date)
    }
}