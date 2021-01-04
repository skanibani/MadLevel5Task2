package com.example.madlevel5task2.database

import android.content.Context
import androidx.lifecycle.LiveData
import com.example.madlevel5task2.model.Game
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class GameRepository(context: Context) {

    private val gameDao: GameDao
    private val mainScope = CoroutineScope(Dispatchers.Main)

    init {
        gameDao = GameRoomDatabase.getInstance(context).gameDao
    }

    fun getAllGames(): LiveData<List<Game>> {
        return gameDao.getAll()
    }

    fun insertGame(game: Game) {
        mainScope.launch {
            withContext(Dispatchers.IO) {
                gameDao.insert(game)
            }
        }
    }

    fun updateGame(game: Game) {
        mainScope.launch {
            withContext(Dispatchers.IO) {
                gameDao.update(game)
            }
        }
    }

    fun deleteAllItems() {
        mainScope.launch {
            withContext(Dispatchers.IO) {
                gameDao.deleteAll()
            }
        }
    }
}