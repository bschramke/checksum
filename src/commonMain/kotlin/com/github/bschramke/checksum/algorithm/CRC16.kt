package com.github.bschramke.checksum.algorithm

class CRC16 {

    object Params {
        val ccittFalse = Algorithm.Params("CRC-16/CCITT-FALSE", 16, 0x1021, 0xFFFF, false, false, 0x0000, 0x29B1)
        val ccittZero = Algorithm.Params("CRC-16/CCITT-ZERO", 16, 0x1021, 0x0000, false, false, 0x0000, 0x29B1)
        val xmodem     = Algorithm.Params("CRC-16/XMODEM", 16, 0x1021, 0x0000, false, false, 0x0000, 0x31C3)

        fun all() = listOf(ccittFalse, ccittZero, xmodem)
    }
}