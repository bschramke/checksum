package com.github.bschramke.checksum

interface Checksum {
    /**@return the current checksum value */
    val value:Long

    /**resets the checksum to its initial value. */
    fun reset()

    /**
     * Updates the current checksum with the specified array of bytes.
     *
     * @param bytes the byte array to update the checksum with
     * @param offset the start offset of the data
     * @param len the number of bytes to use for the update
     **/
    fun update(bytes:ByteArray, offset:Int=0, len:Int=bytes.size)

    /**Updates the current checksum with the specified byte. */
    fun update(bytes:Int)
}
