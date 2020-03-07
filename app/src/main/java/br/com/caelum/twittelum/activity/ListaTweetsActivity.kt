package br.com.caelum.twittelum.activity

import android.content.Intent
import android.os.Bundle
import android.widget.ArrayAdapter
import androidx.appcompat.app.AppCompatActivity
import br.com.caelum.twittelum.R
import br.com.caelum.twittelum.db.TwittelumDatabase
import br.com.caelum.twittelum.modelo.Tweet
import kotlinx.android.synthetic.main.lista_tweets_activity.*

class ListaTweetsActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.lista_tweets_activity)

        val database = TwittelumDatabase.getInstance(this)
        val dao = database.getTweetDao()
        val tweets = dao.busca()

        listaTweets.adapter =
            ArrayAdapter<Tweet>(this, android.R.layout.simple_list_item_1, tweets)


        btnNewTweet.setOnClickListener {
            val intencao = Intent(this, TweetActivity::class.java)
            startActivity(intencao)
        }
    }

}
