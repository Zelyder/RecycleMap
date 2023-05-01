package com.zelyder.recyclemap.data.data_source

import com.zelyder.recyclemap.domain.model.Feed
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import org.jsoup.Jsoup
import org.jsoup.nodes.Document

class RiaNews: News {
    override suspend fun fetch(document: Document?): List<Feed> = withContext(Dispatchers.IO){
        val doc: Document = document ?: Jsoup.connect("https://ria.ru/eco/").get()
        val posts = doc.select(".list-item")
        val list = mutableListOf<Feed>()

        for (post in posts){
            val imgUrl = post.select("img").attr("src")
            val titleEl = post.select(".list-item__title")
            val title = titleEl.text()
            val url = titleEl.attr("href")
            val date = post.select(".list-item__date").text()

            val feed = Feed(
                imageUrl = imgUrl,
                date = date,
                url = url,
                title = title
            )
            list.add(feed)
        }
        list
    }
}