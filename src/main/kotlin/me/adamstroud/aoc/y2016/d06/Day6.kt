package me.adamstroud.aoc.y2016.d06

class Day6 {
    fun run(input: String): String {
        val charCountList: MutableList<MutableMap<Char, Int>> = ArrayList()


        input.lines()
                .map { it.trim() }
                .forEach {
                    for (i in 0..it.length - 1) {
                        val char = it[i]

                        if (charCountList.size <= i) {
                            charCountList.add(HashMap())
                        }

                        val countMap: MutableMap<Char, Int> = charCountList[i]

                        countMap.putIfAbsent(char, 0)
                        countMap.put(char, countMap[char]!!.plus(1))
                    }
                }

        return charCountList
                .map { it.maxBy { it.value } }
                .map { it!!.key.toString() }
                .reduce { acc, c -> acc + c }
    }
}