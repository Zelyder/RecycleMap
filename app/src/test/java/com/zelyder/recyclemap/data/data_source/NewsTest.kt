package com.zelyder.recyclemap.data.data_source

import com.zelyder.recyclemap.domain.model.Feed
import kotlinx.coroutines.runBlocking
import org.jsoup.Jsoup
import org.junit.Assert
import org.junit.Test

class NewsTest {

    private fun isParsingNewsHtmlCorrect(
        news: News,
        fileName: String,
        expectedList: List<Feed>
    ) = runBlocking {
        val file = this.javaClass.getResource(fileName)?.readText()
        val doc = file?.let { Jsoup.parse(it) }
        if (doc != null) {
            val list = news.fetch(doc)
            Assert.assertEquals(expectedList, list)
        } else {
            assert(false)
        }
    }



    @Test
    fun isParsingEcosocietyHtmlCorrect() {
        val expectedList = listOf(
            Feed(
                title = "Стартовал новый сезон конкурса «Большая перемена»",
                imageUrl = "./Все Новости • Российское экологическое общество_files/2104235-1024x576.jpg",
                date = "21.04.2023",
                url = "https://www.ecosociety.ru/news/startoval-novyj-sezon-konkursa-bolshaya-peremena/"
            ),
            Feed(
                title = "Делегация новосибирских экспертов РЭО посетила Казань в рамках Всероссийской олимпиады по экологии",
                imageUrl = "./Все Новости • Российское экологическое общество_files/2104234-1024x462.jpg",
                date = "21.04.2023",
                url = "https://www.ecosociety.ru/news/delegatsiya-novosibirskih-ekspertov-reo-posetila-kazan-v-ramkah-vserossijskoj-olimpiady-po-ekologii/"
            ),
            Feed(
                title = "Екатерина Евсеева приняла участие в международном круглом столе по органике",
                imageUrl = "./Все Новости • Российское экологическое общество_files/2104233-1024x827.jpg",
                date = "21.04.2023",
                url = "https://www.ecosociety.ru/news/ekaterina-evseeva-prinyala-uchastie-v-mezhdunarodnom-kruglom-stole-po-organike/"
            ),
            Feed(
                title = "Приглашаем к участию в V Всероссийском конкурсе «Надежный партнер – Экология»!",
                imageUrl = "./Все Новости • Российское экологическое общество_files/2104232.jpg",
                date = "21.04.2023",
                url = "https://www.ecosociety.ru/news/priglashaem-k-uchastiyu-v-v-vserossijskom-konkurse-nadezhnyj-partner-ekologiya/"
            ),
            Feed(
                title = "Закон об автоматическом мониторинге выбросов принят",
                imageUrl = "./Все Новости • Российское экологическое общество_files/210423-1024x567.jpg",
                date = "21.04.2023",
                url = "https://www.ecosociety.ru/news/zakon-ob-avtomaticheskom-monitoringe-vybrosov-prinyat/"
            ),
            Feed(
                title = "«Чистый десант» с участием Российского экологического общества высадился во Владивостоке",
                imageUrl = "./Все Новости • Российское экологическое общество_files/2004233-1024x768.jpg",
                date = "20.04.2023",
                url = "https://www.ecosociety.ru/news/chistyj-desant-s-uchastiem-rossijskogo-ekologicheskogo-obshhestva-vysadilsya-vo-vladivostoke/"
            ),
            Feed(
                title = "Состоялась презентация нового EcoTech-сервиса Smart Waste",
                imageUrl = "./Все Новости • Российское экологическое общество_files/2004232-1024x681.jpg",
                date = "20.04.2023",
                url = "https://www.ecosociety.ru/news/sostoyalas-prezentatsiya-novogo-ecotech-servisa-smart-waste/"
            ),
            Feed(
                title = "Неделя экознаний прошла в Мордовии",
                imageUrl = "./Все Новости • Российское экологическое общество_files/200423-988x1024.jpg",
                date = "20.04.2023",
                url = "https://www.ecosociety.ru/news/nedelya-ekoznanij-proshla-v-mordovii/"
            ),
            Feed(
                title = "В Тюменской области состоялся региональный экологический форум «Зелёная планета 2023»",
                imageUrl = "./Все Новости • Российское экологическое общество_files/1904233-1024x683.jpg",
                date = "19.04.2023",
                url = "https://www.ecosociety.ru/news/v-tyumenskoj-oblasti-sostoyalsya-regionalnyj-ekologicheskij-forum-zelyonaya-planeta-2023/"
            ),
            Feed(
                title = "Эксперты Мордовского отделения РЭО приняли участие в Стратсессии по благоустройству Ботанического сада",
                imageUrl = "./Все Новости • Российское экологическое общество_files/1904232-1024x681.jpg",
                date = "19.04.2023",
                url = "https://www.ecosociety.ru/news/eksperty-mordovskogo-otdeleniya-reo-prinyali-uchastie-v-stratsessii-po-blagoustrojstvu-botanicheskogo-sada/"
            )
        )
        isParsingNewsHtmlCorrect(
            news = EcosocietyNews(),
            fileName = "/html/ecosociety.html",
            expectedList = expectedList
        )
    }

    @Test
    fun isPrasingRsborHtmlCorrect() {
        val expectedList = listOf(
            Feed(
                imageUrl = "https://rsbor-msk.ru/wp-content/uploads/2022/02/muppets-kermit-2015-600x400.jpg",
                date = "16.12.2022",
                url = "https://rsbor-msk.ru/2022/12/16/label/",
                title = "Какие этикетки снимать при сдаче вторсырья"
            ),
            Feed(
                imageUrl = "https://rsbor-msk.ru/wp-content/uploads/2022/11/1653049172_a05e569a4039cc1c2414af54cf629607-600x400.jpg",
                date = "21.11.2022",
                url = "https://rsbor-msk.ru/2022/11/21/cash_recycle/",
                title = "Пункты приёма вторсырья за деньги"
            ),
            Feed(
                imageUrl = "https://rsbor-msk.ru/wp-content/uploads/2022/10/photo_5393341526697951576_y-600x400.jpg",
                date = "27.10.2022",
                url = "https://rsbor-msk.ru/2022/10/27/gribki/",
                title = "Новая площадка для раздельного сбора в Грибках (Дмитровское шоссе)"
            ),
            Feed(
                imageUrl = "https://rsbor-msk.ru/wp-content/uploads/2019/06/люди-лера-выступление-лекция-стрелка-600x400.jpg",
                date = "20.10.2022",
                url = "https://rsbor-msk.ru/2022/10/20/novaya-lekciya-pro-grinvoshing-22-oktyabrya-v-moskve/",
                title = "Новая лекция про гринвошинг 22 октября в Москве"
            ),
            Feed(
                imageUrl = "https://rsbor-msk.ru/wp-content/uploads/2022/10/photo_5325748980660944943_x-e1665579234323-401x400.jpg",
                date = "12.10.2022",
                url = "https://rsbor-msk.ru/2022/10/12/5-novyx-tochek-po-sboru-blisterov-ot-lekarstv-v-moskve/",
                title = "5 новых точек по сбору блистеров от лекарств в Москве"
            ),
            Feed(
                imageUrl = "https://rsbor-msk.ru/wp-content/uploads/2022/07/лого2-600x400.jpg",
                date = "27.07.2022",
                url = "https://rsbor-msk.ru/2022/07/27/30-festivalej-menyajsya-v-moskve/",
                title = "30 фестивалей «Меняйся» в Москве"
            ),
            Feed(
                imageUrl = "https://rsbor-msk.ru/wp-content/uploads/2022/05/Постер__шары-600x400.jpg",
                date = "23.05.2022",
                url = "https://rsbor-msk.ru/2022/05/23/poster-balloon/",
                title = "Новый плакат про запуск шаров"
            ),
            Feed(
                imageUrl = "https://rsbor-msk.ru/wp-content/uploads/2022/04/img_4280-scaled-e1631774952556-600x400.jpg",
                date = "27.04.2022",
                url = "https://rsbor-msk.ru/2022/04/27/ecovap/",
                title = "Новые пункты покупки вторсырья от Ecovap"
            ),
            Feed(
                imageUrl = "https://rsbor-msk.ru/wp-content/uploads/2020/09/электроника-телефоны-электролом-техника.png",
                date = "18.04.2022",
                url = "https://rsbor-msk.ru/2022/04/18/akcii-obmena-veshhej-zelyonaya-subbota-v-moskve/",
                title = "Акции обмена вещей «Зелёная суббота» в Москве"
            ),
            Feed(
                imageUrl = "https://rsbor-msk.ru/wp-content/uploads/2021/08/b1978564161793.5ac915c4119eb-600x400.jpg",
                date = "01.04.2022",
                url = "https://rsbor-msk.ru/2022/04/01/ekovakansii-aprel/",
                title = "Эковакансии: апрель"
            )
        )
        isParsingNewsHtmlCorrect(
            news = RsborNews(),
            fileName = "/html/rsbor.html",
            expectedList = expectedList
        )
    }

    @Test
    fun isParsingRiaHtmlCorrect() {
        val expectedList = listOf(
            Feed(imageUrl = "./Экология - последние новости сегодня - РИА Новости_files/1866732841_0_73_800_523_600x0_80_0_0_0552351470b3ad0ad55b97ed06bc8416.jpg.webp", date = "20 апреля, 19:21", url = "https://radiosputnik.ria.ru/20230420/podmoskove-1866733479.html", title = "Защиту подмосковного заказника усилят из-за сообщений о нарушениях"),
            Feed(imageUrl = "./Экология - последние новости сегодня - РИА Новости_files/1866578699_0_531_892_1033_600x0_80_0_0_44ab721ce7632be3ce6a4516ab488f2b.jpg.webp", date = "20 апреля, 11:55", url = "https://ria.ru/20230420/dym-1866567087.html", title = "Петербуржцы снова заметили \"рыжий дым\" над Кировским заводом"),
            Feed(imageUrl = "./Экология - последние новости сегодня - РИА Новости_files/1570181167_0_160_3072_1888_600x0_80_0_0_bc5e58e693052b030d4cf37a9e11c91e.jpg.webp", date = "19 апреля, 22:39", url = "https://radiosputnik.ria.ru/20230419/navodnenie-1866481340.html", title = "Экономист: Украина может понести большие убытки из-за небывалого паводка"),
            Feed(imageUrl = "./Экология - последние новости сегодня - РИА Новости_files/1778834650_0_108_3258_1941_600x0_80_0_0_6268ba342de2f8a42d9b71be0c7024c5.jpg.webp", date = "19 апреля, 16:11", url = "https://radiosputnik.ria.ru/20230419/ovoschi-1866380596.html", title = "Сенатор Двойных: экологически чистые овощи станут доступнее для россиян"),
            Feed(imageUrl = "./Экология - последние новости сегодня - РИА Новости_files/1815223415_0_240_3213_2047_600x0_80_0_0_d88396eab70a84c828e08809a3604528.jpg.webp", date = "18 апреля, 14:02", url = "https://ria.ru/20230418/reka-1866067338.html", title = "В Москве произошла утечка топлива в реку"),
            Feed(imageUrl = "./Экология - последние новости сегодня - РИА Новости_files/967545303_0_18_3000_1706_600x0_80_0_0_9a83646011f57c46f72ff8ecfa17f7fd.jpg.webp", date = "18 апреля, 13:23", url = "https://ria.ru/20230418/pozhar-1866057145.html", title = "В Тверской области загорелась свалка"),
            Feed(imageUrl = "./Экология - последние новости сегодня - РИА Новости_files/1864722575_0_56_3072_1784_600x0_80_0_0_d5b1020e2bf4e1abe69a52d9531bda91.jpg.webp", date = "18 апреля, 08:00", url = "https://ria.ru/20230418/nauka-1864767697.html", title = "В России предложили новую эффективную технологию очистки сточных вод"),
            Feed(imageUrl = "./Экология - последние новости сегодня - РИА Новости_files/1573073573_0_154_3094_1894_600x0_80_0_0_3e2bba3d72b75bc4cfec3fa51ee86fd2.jpg.webp", date = "18 апреля, 04:00", url = "https://radiosputnik.ria.ru/20230418/klumba-1865780515.html", title = "Автоэксперт рассказал, почему нельзя делать клумбы из старых шин"),
            Feed(imageUrl = "./Экология - последние новости сегодня - РИА Новости_files/1865744886_0_417_2730_1953_600x0_80_0_0_0104dafd49c3aae41f89c339043d8b90.jpg.webp", date = "17 апреля, 10:25", url = "https://ria.ru/20230417/raykhsbryuke-1865745695.html", title = "Климатические активисты перекрыли один из самых известных мостов в Вене"),
            Feed(imageUrl = "./Экология - последние новости сегодня - РИА Новости_files/1496631655_0_194_3083_1928_600x0_80_0_0_76b7f1fcfb01e759d341f6c7aa52d354.jpg.webp", date = "15 апреля, 21:28", url = "https://radiosputnik.ria.ru/20230415/neftyanoe-pyatno-1865585618.html", title = "В акватории Невы обнаружили большое масляное пятно"),
            Feed(imageUrl = "./Экология - последние новости сегодня - РИА Новости_files/1830881621_0_197_2943_1852_600x0_80_0_0_e8ddc1dd4c5f3ab8f362f70b04f247f1.jpg.webp", date = "15 апреля, 17:27", url = "https://radiosputnik.ria.ru/20230415/ekotsentr-1865567455.html", title = "Собянин рассказал о работе экоцентров в Москве"),
            Feed(imageUrl = "./Экология - последние новости сегодня - РИА Новости_files/1865104350_0_312_960_852_600x0_80_0_0_10c2c9254d37de33fb1f4c2955156a46.jpg.webp", date = "13 апреля, 16:31", url = "https://ria.ru/20230413/pepel-1865100578.html", title = "В Белгороде выпал \"белый дождь\""),
            Feed(imageUrl = "./Экология - последние новости сегодня - РИА Новости_files/1865006266_0_370_960_910_600x0_80_0_0_0c03861e32aa42dd39e917ac46b261fa.jpg.webp", date = "13 апреля, 12:02", url = "https://ria.ru/20230413/vodoemy-1865009592.html", title = "В Белгородской области появились красные водоемы с резким запахом"),
            Feed(imageUrl = "./Экология - последние новости сегодня - РИА Новости_files/1864783418_0_241_3071_1968_600x0_80_0_0_fe13b9f80188afaf97a8b710d7b04de1.jpg.webp", date = "13 апреля, 08:00", url = "https://ria.ru/20230413/ssha-1864781668.html", title = "Раскулачивание по-американски. В США будут отбирать частную собственность"),
            Feed(imageUrl = "./Экология - последние новости сегодня - РИА Новости_files/1831568223_0_160_3072_1888_600x0_80_0_0_f97a35376a607e868e081f71f175c2b9.jpg.webp", date = "10 апреля, 12:41", url = "https://ria.ru/20230410/vozdukh-1864212099.html", title = "Воздух в Москве в марте 2023 года оказался чище, чем год назад"),
            Feed(imageUrl = "./Экология - последние новости сегодня - РИА Новости_files/1863484349_0_675_2008_1805_600x0_80_0_0_eb08db021ceb795f17011cffe08bcf3b.png.webp", date = "9 апреля, 08:00", url = "https://ria.ru/20230409/energetika-1863763637.html", title = "Не нефтью единой. Россия осваивает бесплатный источник энергии"),
            Feed(imageUrl = "./Экология - последние новости сегодня - РИА Новости_files/1589643805_0_320_3072_2048_600x0_80_0_0_623d92cb591b254a9a991cae00b339f0.jpg.webp", date = "6 апреля, 19:24", url = "https://radiosputnik.ria.ru/20230406/posuda-1863531276.html", title = "Запрет на продажу одноразовой посуды возле Байкала обсудили в ГД"),
            Feed(imageUrl = "./Экология - последние новости сегодня - РИА Новости_files/1564090555_0_159_3078_1890_600x0_80_0_0_688c6ea93978b6d5b99d07b086f99120.jpg.webp", date = "6 апреля, 13:56", url = "https://ria.ru/20230406/spg-1863468957.html", title = "В Братиславе экоактивисты выступили против строительства терминала для СПГ"),
            Feed(imageUrl = "./Экология - последние новости сегодня - РИА Новости_files/1490589259_0_640_1366_1408_600x0_80_0_0_290f92d2b3a737aa583dcb2398203d58.jpg.webp", date = "6 апреля, 11:16", url = "https://ria.ru/20230406/sochi-1863407243.html", title = "В Сочи на неопределенный срок закрыли огромную часть нацпарка"),
            Feed(imageUrl = "./Экология - последние новости сегодня - РИА Новости_files/1495012924_0_415_3993_2661_600x0_80_0_0_a2b6b8352770e60f34b37283a27ad035.jpg.webp", date = "5 апреля, 13:35", url = "https://ria.ru/20230405/norilsk-1863185355.html", title = "Норильск возглавил антирейтинг городов России по вредным выбросам"),
        )
        isParsingNewsHtmlCorrect(
            news = RiaNews(),
            fileName = "/html/ria.html",
            expectedList = expectedList
        )
    }
}