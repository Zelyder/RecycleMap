package com.zelyder.recyclemap.data.data_source

import com.zelyder.recyclemap.domain.model.Feed
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import org.jsoup.Jsoup
import org.jsoup.nodes.Document

class RsborNews: News {
    override suspend fun fetch(document: Document?): List<Feed> = withContext(Dispatchers.IO){
        val doc: Document = document ?: Jsoup.connect("https://rsbor-msk.ru/novosti-2/").get()
        val posts = doc.select(".tm-posts_item")
        val list = mutableListOf<Feed>()

        for (post in posts) {
            val img = post.select("img")
            val imgUrl = img.attr("src")
            val title = img.attr("alt")
            val url = post.select("h4 a").attr("href")
            val date = post.select("time").text()

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

//            builder.append("Feed(imageUrl = \"$imgUrl\", date = \"$date\", url = \"$url\", title = \"$title\"), ")