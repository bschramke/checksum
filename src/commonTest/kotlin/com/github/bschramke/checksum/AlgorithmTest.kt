package com.github.bschramke.checksum

import com.github.bschramke.checksum.algorithm.Algorithm
import com.github.bschramke.checksum.algorithm.CRC16
import kotlin.reflect.KClass
import kotlin.test.Test
import kotlin.test.assertEquals
import kotlin.test.assertFailsWith

class AlgorithmTest {
    private val testBytes: ByteArray = "123456789".toByteArray()

    @Test
    fun `should calculate correct CRC-16 checksum` () {
        CRC16.Params.all().forEach {
            val algorithm = Algorithm.create(it)
            val crc = algorithm.calculate(testBytes)

            assertEquals(it.check, crc)
        }
    }
}