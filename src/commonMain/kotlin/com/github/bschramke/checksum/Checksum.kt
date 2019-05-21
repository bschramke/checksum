package com.github.bschramke.checksum

interface Checksum {
    /**@return the current checksum value */
    val value:Long

    /**resets the checksum to its initial value. */
    fun reset()

    /**Updates the current checksum with the specified array of bytes. */
    fun update(bytes:ByteArray, offset:Int, len:Int)

    /**Updates the current checksum with the specified byte. */
    fun update(bytes:Int)
}
