package com.github.bschramke.checksum

/**
 * @param value the value to be reversed
 * @param value the amount of bits to be revesed.
 */
internal fun reverseBitsImpl(value:Long, length: Int):Long {
    var ul = value
    var newValue: Long = 0

    for (i in length - 1 downTo 0) {
        newValue = newValue or (ul and 1 shl i)
        ul = ul shr 1
    }

    return newValue
}

infix fun Byte.shl(other: Byte): Byte = (this.toInt() shl other.toInt()).toByte()

fun Int.reverseBits(length: Int):Long = reverseBitsImpl(this.toLong(), length)
fun Long.reverseBits(length: Int):Long = reverseBitsImpl(this, length)