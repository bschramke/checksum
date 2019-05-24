package com.github.bschramke.checksum.algorithm

import com.github.bschramke.checksum.reverseBits
import com.github.bschramke.checksum.reverseBitsImpl

internal fun calculateLookupTable(params: Algorithm.Params):LongArray {
    val table = LongArray(256)

    for (idx in table.indices) {
        var crc:Long = when {
            params.reflectedIn  -> idx.reverseBits(params.width)
            params.width > 8    -> idx.toLong() shl (params.width -8)
            else                -> idx.toLong()
        }

        for (i in 0..7) {
            // check if MSB is set
            crc = if((crc and params.msb) != 0L) {
                // most significant bit set, shift crc register and perform XOR operation
                (crc shl 1) xor params.generator
            }else {
                // most significant bit not set, go to next bit
                crc shl 1
            }
        }

        if(params.reflectedOut) {
            crc = reverseBitsImpl(crc, params.width)
        }

        table[idx] = crc and params.mask
    }

    return table
}