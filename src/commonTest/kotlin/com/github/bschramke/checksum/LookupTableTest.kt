package com.github.bschramke.checksum

import com.github.bschramke.checksum.algorithm.CRC16
import com.github.bschramke.checksum.algorithm.calculateLookupTable
import com.github.bschramke.checksum.testdata.Crc16LookupTables
import kotlin.test.Test
import kotlin.test.assertTrue

class LookupTableTest {

    @Test
    fun `should calculate correct lookup table for CRC16-CCITT-FALSE` () {
        val table = calculateLookupTable(CRC16.Params.ccittFalse)

        assertTrue(Crc16LookupTables.ccittFalse.contentEquals(table))
    }

    @Test
    fun `should calculate correct lookup table for CRC16-XMODEM` () {
        val table = calculateLookupTable(CRC16.Params.xmodem)

        assertTrue(Crc16LookupTables.ccittFalse.contentEquals(table))
    }

}