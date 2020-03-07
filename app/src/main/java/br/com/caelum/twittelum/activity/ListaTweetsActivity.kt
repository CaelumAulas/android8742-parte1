package br.com.caelum.twittelum.activity

import android.content.Intent
import android.os.Bundle
import android.widget.ArrayAdapter
import androidx.appcompat.app.AppCompatActivity
import br.com.caelum.twittelum.R
import kotlinx.android.synthetic.main.lista_tweets_activity.*

class ListaTweetsActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.lista_tweets_activity)

        val tweets = arrayListOf(
            "Hoje deu ruim nos pcs :(",
            "Semana que vem não vai dar ruim ( eu espero )",
            "Sinto fome",
            "Kotlin é legal",
            "Sei la",
            "Outro sei la",
            "zzzZZZzzZZz"
        )

        listaTweets.adapter =
            ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, tweets)


        btnNewTweet.setOnClickListener {
            val intencao = Intent(this, TweetActivity::class.java)
            startActivity(intencao)
        }
    }

}
