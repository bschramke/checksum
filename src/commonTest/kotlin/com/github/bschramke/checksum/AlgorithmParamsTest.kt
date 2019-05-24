package com.github.bschramke.checksum

import com.github.bschramke.checksum.algorithm.Algorithm
import kotlin.reflect.KClass
import kotlin.test.Test
import kotlin.test.assertFailsWith

class AlgorithmParamsTest {

    @Test
    fun `should throw on zero width` () {
        shouldThrowOnWidth(IllegalArgumentException::class, 0)
    }

    @Test
    fun `should throw on negative width` () {
        shouldThrowOnWidth(IllegalArgumentException::class, -10)
    }

    @Test
    fun `should throw on too big width` () {
        shouldThrowOnWidth(IllegalArgumentException::class, 68)
    }

    private fun <T:Exception> shouldThrowOnWidth(exception: KClass<T>, width: Int) {
        assertFailsWith(exception) {
            Algorithm.Params("", width, 0xff, 0, false, false, 0, 0)
        }
    }
}