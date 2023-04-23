package com.zelyder.recyclemap.data.data_source

import com.zelyder.recyclemap.domain.model.Feed
import kotlinx.coroutines.test.runTest
import org.jsoup.Jsoup
import org.junit.Assert
import org.junit.Test

class NewsTest {

    @Test
    fun isParsingEcosocietyHtmlCorrect() = runTest{
        val news = EcosocietyNews()
        val file = this.javaClass.getResource("/html/ecosociety.html")?.readText()
        val doc = file?.let { Jsoup.parse(it) }
        if (doc != null) {
            val list = news.fetch(doc)
            val expectedList = listOf(
                Feed(title="Стартовал новый сезон конкурса «Большая перемена»",
                    imageUrl="./Все Новости • Российское экологическое общество_files/2104235-1024x576.jpg",
                    date="21.04.2023",
                    url="https://www.ecosociety.ru/news/startoval-novyj-sezon-konkursa-bolshaya-peremena/"),
                Feed(title="Делегация новосибирских экспертов РЭО посетила Казань в рамках Всероссийской олимпиады по экологии",
                    imageUrl="./Все Новости • Российское экологическое общество_files/2104234-1024x462.jpg",
                    date="21.04.2023",
                    url="https://www.ecosociety.ru/news/delegatsiya-novosibirskih-ekspertov-reo-posetila-kazan-v-ramkah-vserossijskoj-olimpiady-po-ekologii/"),
                Feed(title="Екатерина Евсеева приняла участие в международном круглом столе по органике",
                    imageUrl="./Все Новости • Российское экологическое общество_files/2104233-1024x827.jpg",
                    date="21.04.2023",
                    url="https://www.ecosociety.ru/news/ekaterina-evseeva-prinyala-uchastie-v-mezhdunarodnom-kruglom-stole-po-organike/"),
                Feed(title="Приглашаем к участию в V Всероссийском конкурсе «Надежный партнер – Экология»!",
                    imageUrl="./Все Новости • Российское экологическое общество_files/2104232.jpg",
                    date="21.04.2023",
                    url="https://www.ecosociety.ru/news/priglashaem-k-uchastiyu-v-v-vserossijskom-konkurse-nadezhnyj-partner-ekologiya/"),
                Feed(title="Закон об автоматическом мониторинге выбросов принят",
                    imageUrl="./Все Новости • Российское экологическое общество_files/210423-1024x567.jpg",
                    date="21.04.2023",
                    url="https://www.ecosociety.ru/news/zakon-ob-avtomaticheskom-monitoringe-vybrosov-prinyat/"),
                Feed(title="«Чистый десант» с участием Российского экологического общества высадился во Владивостоке",
                    imageUrl="./Все Новости • Российское экологическое общество_files/2004233-1024x768.jpg",
                    date="20.04.2023",
                    url="https://www.ecosociety.ru/news/chistyj-desant-s-uchastiem-rossijskogo-ekologicheskogo-obshhestva-vysadilsya-vo-vladivostoke/"),
                Feed(title="Состоялась презентация нового EcoTech-сервиса Smart Waste",
                    imageUrl="./Все Новости • Российское экологическое общество_files/2004232-1024x681.jpg",
                    date="20.04.2023",
                    url="https://www.ecosociety.ru/news/sostoyalas-prezentatsiya-novogo-ecotech-servisa-smart-waste/"),
                Feed(title="Неделя экознаний прошла в Мордовии",
                    imageUrl="./Все Новости • Российское экологическое общество_files/200423-988x1024.jpg",
                    date="20.04.2023",
                    url="https://www.ecosociety.ru/news/nedelya-ekoznanij-proshla-v-mordovii/"),
                Feed(title="В Тюменской области состоялся региональный экологический форум «Зелёная планета 2023»",
                    imageUrl="./Все Новости • Российское экологическое общество_files/1904233-1024x683.jpg",
                    date="19.04.2023",
                    url="https://www.ecosociety.ru/news/v-tyumenskoj-oblasti-sostoyalsya-regionalnyj-ekologicheskij-forum-zelyonaya-planeta-2023/"),
                Feed(title="Эксперты Мордовского отделения РЭО приняли участие в Стратсессии по благоустройству Ботанического сада",
                    imageUrl="./Все Новости • Российское экологическое общество_files/1904232-1024x681.jpg",
                    date="19.04.2023",
                    url="https://www.ecosociety.ru/news/eksperty-mordovskogo-otdeleniya-reo-prinyali-uchastie-v-stratsessii-po-blagoustrojstvu-botanicheskogo-sada/")
            )
            Assert.assertEquals(expectedList, list)
        } else {
            assert(false)
        }
    }
}