package lesson7

import kotlin.test.assertEquals

abstract class AbstractDynamicTests {
    fun longestCommonSubSequence(longestCommonSubSequence: (String, String) -> String) {
        assertEquals(
            "иь р насольооенто ацинаееоплния",
            longestCommonSubSequence(
                "Дорогие друзья, курс на социально-ориентированный национальный проект требует определения",
                "Значимость этих проблем настолько очевидна, что реализация намеченного плана развития"
            )
        )
        assertEquals(
            " на е тренити в сет интернет, коорые реся обки рме отинталовреого иа почскоы поенло е нам " +
                    "иова ке диар взе ирую обнноиску ет т ы пденты  р евых ов.",
            longestCommonSubSequence(
                "Сделанные на базе интернет-аналитики выводы освещают чрезвычайно интересные особенности картины " +
                        "в целом, однако конкретные выводы, разумеется, объективно рассмотрены соответствующими " +
                        "инстанциями. Для современного мира сплочённость команды профессионалов не даёт нам иного " +
                        "выбора, кроме определения распределения внутренних резервов и ресурсов. Ключевые " +
                        "особенности структуры проекта могут быть подвергнуты целой серии независимых исследований.",
                "Есть над чем задуматься: предприниматели в сети интернет, которые представляют собой яркий пример " +
                        "континентально-европейского типа политической культуры, будут подвергнуты целой серии " +
                        "независимых исследований. А также диаграммы связей формируют глобальную экономическую " +
                        "сеть и при этом - указаны как претенденты на роль ключевых факторов."
            )
        )
        assertEquals("", longestCommonSubSequence("привет", "ПРИВЕТ"))
        assertEquals("", longestCommonSubSequence("мой мир", "я"))
        assertEquals("1", longestCommonSubSequence("1", "1"))
        assertEquals("13", longestCommonSubSequence("123", "13"))
        assertEquals("здс", longestCommonSubSequence("здравствуй мир", "мы здесь"))
        assertEquals("emt ole", longestCommonSubSequence("nematode knowledge", "empty bottle"))
        val expectedLength = "e kerwelkkd r".length
        assertEquals(
            expectedLength, longestCommonSubSequence(
                "oiweijgw kejrhwejelkrw kjhdkfjs hrk",
                "perhkhk lerkerorwetp lkjklvvd durltr"
            ).length, "Answer must have length of $expectedLength, e.g. 'e kerwelkkd r' or 'erhlkrw kjk r'"
        )
        val expectedLength2 = """ дд саы чтых,
евшнео ваа се сви дн.
        """.trimIndent().length
        assertEquals(
            expectedLength2, longestCommonSubSequence(
                """
Мой дядя самых честных правил,
Когда не в шутку занемог,
Он уважать себя заставил
И лучше выдумать не мог.
                """.trimIndent(),
                """
Так думал молодой повеса,
Летя в пыли на почтовых,
Всевышней волею Зевеса
Наследник всех своих родных.
                """.trimIndent()
            ).length, "Answer must have length of $expectedLength2"
        )
    }

    fun longestIncreasingSubSequence(longestIncreasingSubSequence: (List<Int>) -> List<Int>) {
        assertEquals(
            listOf(2, 3, 9, 10, 14, 17, 20, 27, 39, 45, 54, 67, 70, 80, 83, 85),
            longestIncreasingSubSequence(
                listOf(
                    86, 33, 4, 18, 59, 30, 11, 89, 2, 43, 3, 77, 56, 9, 57, 36, 72,
                    22, 47, 51, 10, 90, 75, 38, 63, 61, 79, 50, 60, 8, 40, 14, 53, 65, 42, 71, 31, 81, 1, 17, 15,
                    20, 5, 46, 76, 41, 49, 27, 39, 74, 84, 82, 78, 45, 69, 19, 54, 52, 67, 70, 87, 88, 25, 35, 55,
                    37, 80, 64, 12, 34, 28, 29, 66, 6, 44, 21, 58, 13, 32, 83, 26, 85, 7, 68, 73, 23, 16, 24, 48, 62
                )
            )
        )
        assertEquals(
            listOf(94, 100, 299, 349, 362, 501, 683, 754, 787, 790, 801, 852, 907, 986),
            longestIncreasingSubSequence(
                listOf(
                    826, 679, 400, 298, 785, 494, 372, 94, 928, 825, 313, 370, 719, 790, 774, 100, 583, 505, 825, 299,
                    22, 711, 489, 349, 362, 711, 501, 306, 683, 83, 152, 381, 754, 787, 790, 310, 368, 31, 170, 440,
                    801, 759, 852, 38, 20, 907, 986, 218, 85, 485
                )
            )
        )
        assertEquals(listOf(0, 1), longestIncreasingSubSequence(listOf(0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1)))
        assertEquals(listOf(), longestIncreasingSubSequence(listOf()))
        assertEquals(listOf(1), longestIncreasingSubSequence(listOf(1)))
        assertEquals(listOf(1, 2), longestIncreasingSubSequence(listOf(1, 2)))
        assertEquals(listOf(2), longestIncreasingSubSequence(listOf(2, 1)))
        assertEquals(
            listOf(1, 2, 3, 4, 5, 6, 7, 8, 9, 10),
            longestIncreasingSubSequence(listOf(1, 2, 3, 4, 5, 6, 7, 8, 9, 10))
        )
        assertEquals(listOf(2, 8, 9, 12), longestIncreasingSubSequence(listOf(2, 8, 5, 9, 12, 6)))
        assertEquals(
            listOf(23, 34, 56, 87, 91, 98, 140, 349), longestIncreasingSubSequence(
                listOf(
                    23, 76, 34, 93, 123, 21, 56, 87, 91, 12, 45, 98, 140, 12, 5, 38, 349, 65, 94,
                    45, 76, 15, 99, 100, 88, 84, 35, 88
                )
            )
        )
    }

    fun shortestPathOnField(shortestPathOnField: (String) -> Int) {
        assertEquals(1, shortestPathOnField("input/field_in2.txt"))
        assertEquals(12, shortestPathOnField("input/field_in1.txt"))
        assertEquals(43, shortestPathOnField("input/field_in3.txt"))
        assertEquals(28, shortestPathOnField("input/field_in4.txt"))
        assertEquals(222, shortestPathOnField("input/field_in5.txt"))
        assertEquals(15, shortestPathOnField("input/field_in6.txt"))
    }

}