package br.com.caelum.twittelum.repository

import br.com.caelum.twittelum.db.TweetDao
import br.com.caelum.twittelum.modelo.Tweet

class TweetRepository(val dao: TweetDao) {

    fun salva(tweet: Tweet) = dao.salva(tweet)

    fun busca() = dao.busca()
}
