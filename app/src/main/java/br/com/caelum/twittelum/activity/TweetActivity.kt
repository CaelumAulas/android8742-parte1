package br.com.caelum.twittelum.activity

import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import br.com.caelum.twittelum.R
import br.com.caelum.twittelum.db.TwittelumDatabase
import br.com.caelum.twittelum.modelo.Tweet
import kotlinx.android.synthetic.main.activity_main.*

class TweetActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        menuInflater.inflate(R.menu.tweet_menu, menu)
        return true
    }


    override fun onOptionsItemSelected(item: MenuItem): Boolean = when (item.itemId) {
        R.id.menuPublicarTweet -> {
            publicaTweet()
            finish()
            true
        }

        android.R.id.home -> {
            finish()
            true
        }
        else -> false
    }

    private fun publicaTweet() {
        val tweet = criaTweet()

        val database = TwittelumDatabase.getInstance(this)
        val tweetDao = database.getTweetDao()
        tweetDao.salva(tweet)

        Toast.makeText(this, "$tweet", Toast.LENGTH_LONG).show()
    }

    private fun criaTweet(): Tweet {
        val conteudo = tweetConteudo.text.toString()

        return Tweet(conteudo)
    }

}

