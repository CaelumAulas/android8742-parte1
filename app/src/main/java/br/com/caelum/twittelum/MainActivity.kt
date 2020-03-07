package br.com.caelum.twittelum

import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

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
            val conteudo = tweetConteudo.text.toString()
            Toast.makeText(this, conteudo, Toast.LENGTH_LONG).show()
            finish()
            true
        }

        android.R.id.home -> {
            finish()
            true
        }
        else -> false
    }


}

