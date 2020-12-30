package com.example.madlevel5task2.database

import androidx.lifecycle.LiveData
import androidx.room.*
import com.example.madlevel5task2.model.Game

@Dao
interface GameDao {
    @Query("SELECT * FROM gameTable")
    fun getAll(): LiveData<List<Game>>

    @Insert
    fun insert(game: Game)

    @Update
    fun update(vararg game: Game)

    @Delete
    fun delete(game: Game)

    @Query("DELETE FROM gameTable")
    fun deleteAll()
}