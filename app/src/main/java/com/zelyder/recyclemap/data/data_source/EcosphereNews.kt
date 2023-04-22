package com.zelyder.recyclemap.data.data_source

import android.util.Log
import com.zelyder.recyclemap.domain.model.Feed
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import org.jsoup.Jsoup
import org.jsoup.nodes.Document
import org.jsoup.select.Elements

class EcosphereNews: News {
    override suspend fun fetch(): List<Feed>  = withContext(Dispatchers.IO){
        val doc: Document = Jsoup.connect("https://www.ecosociety.ru/allnews/").get()
        Log.d("EcosphereNews",doc.title())
        val articles: Elements = doc.select("article")
        val list = mutableListOf<Feed>()

        for (article in articles) {
            val img = article.select("img[src$=.jpg]")
            val imgUrl = img.attr("src")
            val title = img.attr("alt")
            val url = article.select("div h3 a").attr("href")
            val date = article.select("span").text()
            val feed = Feed(
                title = title,
                url = url,
                date = date,
                imageUrl = imgUrl
            )
            Log.d("EcosphereNews",feed.toString())
            list.add(feed)
        }
        list
    }
}