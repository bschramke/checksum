package com.github.bschramke.checksum.algorithm

import com.github.bschramke.checksum.reverseBits
import com.github.bschramke.checksum.xor
import kotlin.math.max

internal class RefOutAlgorithm(params: Algorithm.Params): Algorithm(params) {
    override fun calculate(data: ByteArray, offset: Int, length: Int): Long {
        with(params) {
            var crc = params.seed.reverseBits(params.width)

            for(i in offset until offset + length) {
                val idx = ((crc xor data[i]) and 0xFF).toInt()
                crc = table[idx] xor (crc ushr 8)
                crc = crc and mask
            }

            return (crc xor xorOut) and mask
        }
    }

}

internal class NoRefOutAlgorithm(params: Algorithm.Params): Algorithm(params) {
    private val toRight = max(params.width - 8, 0)

    override fun calculate(data: ByteArray, offset: Int, length: Int): Long {
        with(params) {
            var crc = params.seed

            for(i in offset until offset + length) {
                val idx = (((crc shr toRight) xor data[i]) and 0xFF).toInt()
                crc = table[idx] xor (crc shl 8)
                crc = crc and mask
            }

            return (crc xor xorOut) and mask
        }
    }

}