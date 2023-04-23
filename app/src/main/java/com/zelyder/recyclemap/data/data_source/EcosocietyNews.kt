package com.zelyder.recyclemap.data.data_source

import com.zelyder.recyclemap.domain.model.Feed
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import org.jsoup.Jsoup
import org.jsoup.nodes.Document
import org.jsoup.select.Elements

class EcosocietyNews: News {
    override suspend fun fetch(document: Document?): List<Feed>  = withContext(Dispatchers.IO){
        val doc: Document = document ?: Jsoup.connect("https://www.ecosociety.ru/allnews/").get()
        val articles: Elements = doc.select("article")
        val list = mutableListOf<Feed>()

        for (article in articles) {
            val img = article.select("img")
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
            list.add(feed)
        }
        list
    }
}