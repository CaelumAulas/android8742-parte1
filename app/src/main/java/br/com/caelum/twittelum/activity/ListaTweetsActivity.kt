package br.com.caelum.twittelum.activity

import android.content.Intent
import android.os.Bundle
import android.widget.ArrayAdapter
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import br.com.caelum.twittelum.R
import br.com.caelum.twittelum.db.TwittelumDatabase
import br.com.caelum.twittelum.modelo.Tweet
import br.com.caelum.twittelum.viewmodel.TweetViewModel
import br.com.caelum.twittelum.viewmodel.ViewModelFactory
import kotlinx.android.synthetic.main.lista_tweets_activity.*

class ListaTweetsActivity : AppCompatActivity() {

    val tweetViewModel: TweetViewModel by lazy {
        ViewModelProvider(this, ViewModelFactory).get(TweetViewModel::class.java)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.lista_tweets_activity)

        tweetViewModel.busca().observe(this, Observer { tweets ->
            listaTweets.adapter =
                ArrayAdapter<Tweet>(this, android.R.layout.simple_list_item_1, tweets)

        })


        btnNewTweet.setOnClickListener {
            val intencao = Intent(this, TweetActivity::class.java)
            startActivity(intencao)
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        tweetViewModel
    }

}
