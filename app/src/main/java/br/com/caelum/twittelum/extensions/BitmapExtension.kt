package br.com.caelum.twittelum.extensions

import android.graphics.Bitmap
import android.util.Base64
import java.io.ByteArrayOutputStream
import java.io.OutputStream

fun Bitmap.convertToBase64(): String {

    val outputStream = ByteArrayOutputStream()
    this.compress(Bitmap.CompressFormat.JPEG, 100, outputStream)
    val arrayBytes = outputStream.toByteArray()

    return Base64.encodeToString(arrayBytes, Base64.DEFAULT)
}
