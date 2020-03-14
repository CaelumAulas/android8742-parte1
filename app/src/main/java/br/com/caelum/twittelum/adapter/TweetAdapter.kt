package br.com.caelum.twittelum.adapter

import android.content.Context
import android.graphics.Bitmap
import android.graphics.BitmapFactory
import android.util.Base64
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import br.com.caelum.twittelum.R
import br.com.caelum.twittelum.imagem.Carregador
import br.com.caelum.twittelum.modelo.Tweet
import kotlinx.android.synthetic.main.item_tweet.view.*

class TweetAdapter(val lista: List<Tweet>) : BaseAdapter() {

    override fun getCount(): Int = lista.size

    override fun getItem(position: Int): Tweet = lista[position]

    override fun getItemId(position: Int): Long = getItem(position).id.toLong()

    override fun getView(
        position: Int,
        convertView: View?,
        parent: ViewGroup
    ): View {
        val tweet = getItem(position)

        val inflater = LayoutInflater.from(parent.context)
        val view = inflater.inflate(R.layout.item_tweet, parent, false)

        view.item_conteudo.text = tweet.conteudo

        tweet.foto?.let {
            view.item_foto.visibility = View.VISIBLE
            view.item_foto.setImageBitmap(Carregador.decodifica(it))
        }
        return view
    }
}
