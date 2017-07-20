package me.adamstroud.aoc.y2016.d04

/**
 * TODO
 *
 * @author Adam Stroud &#60;<a href="mailto:adam.stroud@gmail.com">adam.stroud@gmail.com</a>&#62;
 */
class Day4 {
    data class Result(val real: Boolean, val sectorId: Int, val checksum: String)

    fun decode(ciphertext:String): Result {
        val (encryptedName, sectorId, checksum) = ciphertext.replace("(.*)-(.*)\\[(.*)\\]".toRegex(), "$1,$2,$3").split(',')

        val test = encryptedName
                .filter { it != '-' }
                .groupBy { it }
                .mapValues { it.value.size }

        val sortedKeys = test.keys.sortedWith(Comparator { k1, k2 ->
            if (test[k2] == test[k1]) {
                k1!!.compareTo(k2)
            } else {
                test[k2]!!.compareTo(test[k1]!!)
            }
        })

        return Result(String(sortedKeys.toCharArray()).startsWith(checksum), sectorId.toInt(), checksum)
    }
}