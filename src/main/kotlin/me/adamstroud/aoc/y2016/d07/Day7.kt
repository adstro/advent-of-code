package me.adamstroud.aoc.y2016.d07

class Day7 {
    fun hasAbba(address: String) = address.windowed(4, 1, false)
            .any { it[0] == it[3]
                    && it[1] == it[2]
                    && it[0] != it[1] }

    fun getHyperTexts(address: String): List<String> {
        var current: String? = null
        val stringList = emptyList<String>().toMutableList()

        address.forEach {
            when (it) {
                '[' -> current = ""
                ']' -> {
                    stringList.add(current!!)
                    current = null
                }
                else -> current += it
            }
        }

        return stringList
    }

    fun supportsTls(address: String) = hasAbba(address) && (getHyperTexts(address).none { hasAbba(it) })
}