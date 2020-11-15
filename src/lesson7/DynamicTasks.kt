@file:Suppress("UNUSED_PARAMETER")

package lesson7

/**
 * Наибольшая общая подпоследовательность.
 * Средняя
 *
 * Дано две строки, например "nematode knowledge" и "empty bottle".
 * Найти их самую длинную общую подпоследовательность -- в примере это "emt ole".
 * Подпоследовательность отличается от подстроки тем, что её символы не обязаны идти подряд
 * (но по-прежнему должны быть расположены в исходной строке в том же порядке).
 * Если общей подпоследовательности нет, вернуть пустую строку.
 * Если есть несколько самых длинных общих подпоследовательностей, вернуть любую из них.
 * При сравнении подстрок, регистр символов *имеет* значение.
 */
//Время O(first.length * second.length)
//Память O(first.length * second.length)
fun longestCommonSubSequence(first: String, second: String): String {
    var result = ""
    val matchMatrix = Array(first.length + 1) { IntArray(second.length + 1) }
    for (i in first.length - 1 downTo 0) {
        for (j in second.length - 1 downTo 0) {
            matchMatrix[i][j] = if (first[i] == second[j]) 1 + matchMatrix[i + 1][j + 1]
            else maxOf(matchMatrix[i + 1][j], matchMatrix[i][j + 1])
        }
    }
    var i = 0
    var j = 0
    while (i < first.length && j < second.length) {
        if (first[i] == second[j]) {
            result += first[i]
            i++
            j++
        } else {
            if (matchMatrix[i + 1][j] >= matchMatrix[i][j + 1]) {
                i++
            } else {
                j++
            }
        }
    }
    return result
}

/**
 * Наибольшая возрастающая подпоследовательность
 * Сложная
 *
 * Дан список целых чисел, например, [2 8 5 9 12 6].
 * Найти в нём самую длинную возрастающую подпоследовательность.
 * Элементы подпоследовательности не обязаны идти подряд,
 * но должны быть расположены в исходном списке в том же порядке.
 * Если самых длинных возрастающих подпоследовательностей несколько (как в примере),
 * то вернуть ту, в которой числа расположены раньше (приоритет имеют первые числа).
 * В примере ответами являются 2, 8, 9, 12 или 2, 5, 9, 12 -- выбираем первую из них.
 */
//Время O(N * N)
//Память O(N)
fun longestIncreasingSubSequence(list: List<Int>): List<Int> {
    if (list.size <= 1) return list
    val result = mutableListOf<Int>()
    val longestSequence = Array(list.size) { 0 }
    val previous = Array(list.size) { 0 }
    for (i in list.indices) {
        longestSequence[i] = 1
        previous[i] = -1
        for (j in 0 until i) {
            if (list[j] < list[i] && longestSequence[j] + 1 > longestSequence[i]) {
                longestSequence[i] = longestSequence[j] + 1
                previous[i] = j
            }
        }
    }
    var index = 0
    var length = longestSequence[0]
    for (i in list.indices) {
        if (longestSequence[i] > length) {
            index = i
            length = longestSequence[i]
        }
    }
    while (index != -1) {
        result += list[index]
        index = previous[index]
    }
    return result.reversed()
}

/**
 * Самый короткий маршрут на прямоугольном поле.
 * Средняя
 *
 * В файле с именем inputName задано прямоугольное поле:
 *
 * 0 2 3 2 4 1
 * 1 5 3 4 6 2
 * 2 6 2 5 1 3
 * 1 4 3 2 6 2
 * 4 2 3 1 5 0
 *
 * Можно совершать шаги длиной в одну клетку вправо, вниз или по диагонали вправо-вниз.
 * В каждой клетке записано некоторое натуральное число или нуль.
 * Необходимо попасть из верхней левой клетки в правую нижнюю.
 * Вес маршрута вычисляется как сумма чисел со всех посещенных клеток.
 * Необходимо найти маршрут с минимальным весом и вернуть этот минимальный вес.
 *
 * Здесь ответ 2 + 3 + 4 + 1 + 2 = 12
 */
fun shortestPathOnField(inputName: String): Int {
    TODO()
}

// Задачу "Максимальное независимое множество вершин в графе без циклов"
// смотрите в уроке 5