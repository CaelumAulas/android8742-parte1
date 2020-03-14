package br.com.caelum.twittelum.db

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.room.migration.Migration
import androidx.sqlite.db.SupportSQLiteDatabase
import br.com.caelum.twittelum.modelo.Tweet

@Database(entities = [Tweet::class], version = 2)
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
                .addMigrations(Migracao1Para2, Migracao1Para2)
                .build()
        }


    }
}


object Migracao1Para2 : Migration(1, 2) {
    override fun migrate(database: SupportSQLiteDatabase) {
        database.execSQL("alter table Tweet add column foto text;")
    }

}















