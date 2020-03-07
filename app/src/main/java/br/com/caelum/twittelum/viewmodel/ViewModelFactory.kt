package br.com.caelum.twittelum.viewmodel

import android.content.Context
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import br.com.caelum.twittelum.app.TwittelumApplication
import br.com.caelum.twittelum.db.TwittelumDatabase
import br.com.caelum.twittelum.repository.TweetRepository

object ViewModelFactory : ViewModelProvider.NewInstanceFactory() {


    private val contexto : Context = TwittelumApplication.getInstance()
    private val database = TwittelumDatabase.getInstance(contexto)
    private val dao = database.getTweetDao()
    private val repository = TweetRepository(dao)

    @Suppress("UNCHECKED_CAST")
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return TweetViewModel(repository) as T
    }
}
