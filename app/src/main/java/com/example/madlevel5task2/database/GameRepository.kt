package com.example.madlevel5task2.database

import android.content.Context
import androidx.lifecycle.LiveData
import com.example.madlevel5task2.model.Game
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class GameRepository(context: Context) {

    private val gameDao: GameDao

    init {
        val database = GameRoomDatabase.getInstance(context)
        gameDao = database!!.gameDao
    }

    fun getAllGames(): LiveData<List<Game>> {
        return gameDao.getAll()
    }

    suspend fun updateGame(game: Game) {
        gameDao.update(game)
    }
}