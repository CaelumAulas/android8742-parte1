package br.com.caelum.twittelum.activity

import android.app.Activity
import android.content.Intent
import android.graphics.Bitmap
import android.graphics.BitmapFactory
import android.net.Uri
import android.os.Bundle
import android.provider.MediaStore
import android.view.Menu
import android.view.MenuItem
import android.widget.ImageView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.FileProvider
import androidx.lifecycle.ViewModelProvider
import br.com.caelum.twittelum.R
import br.com.caelum.twittelum.modelo.Tweet
import br.com.caelum.twittelum.viewmodel.TweetViewModel
import br.com.caelum.twittelum.viewmodel.ViewModelFactory
import kotlinx.android.synthetic.main.activity_main.*
import java.io.File

class TweetActivity : AppCompatActivity() {


    private var localDaFoto: String? = null

    private val tweetViewModel: TweetViewModel by lazy {
        ViewModelProvider(this, ViewModelFactory).get(TweetViewModel::class.java)
    }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)

    }

    private fun mostraFoto() {
        val bitmap = BitmapFactory.decodeFile(localDaFoto)

        val bitmapBonito = Bitmap.createScaledBitmap(bitmap, 500, 300, true)

        tweetFoto.setImageBitmap(bitmapBonito)

        tweetFoto.scaleType = ImageView.ScaleType.FIT_XY
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        menuInflater.inflate(R.menu.tweet_menu, menu)
        return true
    }


    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (requestCode == 123 && resultCode == Activity.RESULT_OK) mostraFoto()
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean = when (item.itemId) {
        R.id.menuPublicarTweet -> {
            publicaTweet()
            finish()
            true
        }

        R.id.menuCamera -> {
            tiraFoto()
            true
        }

        android.R.id.home -> {
            finish()
            true
        }
        else -> false
    }

    private fun tiraFoto() {
        val vaiParaCamera = Intent(MediaStore.ACTION_IMAGE_CAPTURE)

        val local = defineLocal()
        vaiParaCamera.putExtra(MediaStore.EXTRA_OUTPUT, local)

        startActivityForResult(vaiParaCamera, 123)
    }

    private fun defineLocal(): Uri {
        localDaFoto = "${getExternalFilesDir("foto")}/${System.currentTimeMillis()}.jpg"

        val file = File(localDaFoto)

        return FileProvider.getUriForFile(this, "TweetProvider", file)
    }

    private fun publicaTweet() {
        val tweet = criaTweet()

        tweetViewModel.salva(tweet)

        Toast.makeText(this, "$tweet", Toast.LENGTH_LONG).show()
    }

    private fun criaTweet(): Tweet {
        val conteudo = tweetConteudo.text.toString()

        return Tweet(conteudo)
    }

}

