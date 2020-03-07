package br.com.caelum.twittelum.db

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import br.com.caelum.twittelum.modelo.Tweet

@Database(entities = [Tweet::class], version = 1)
abstract class TwittelumDatabase : RoomDatabase() {

    abstract fun getTweetDao(): TweetDao


    companion object Factory {

        private var database: TwittelumDatabase? = null

        fun getInstance(contexto: Context): TwittelumDatabase {

            return database ?: criaDatabase(contexto).also { database = it }

        }

        private fun criaDatabase(contexto: Context): TwittelumDatabase {
            return Room.databaseBuilder(contexto, TwittelumDatabase::class.java, "TwittelumDB")
                .allowMainThreadQueries()
                .build()
        }


    }
}
