package br.com.caelum.twittelum.imagem

import android.graphics.Bitmap
import android.graphics.BitmapFactory
import android.util.Base64

object Carregador {

    fun decodifica(base64: String): Bitmap {
        val arrayBytes = Base64.decode(base64, Base64.DEFAULT)
        return BitmapFactory.decodeByteArray(arrayBytes, 0, arrayBytes.size)
    }
}
