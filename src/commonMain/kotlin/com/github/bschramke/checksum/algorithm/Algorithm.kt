package com.github.bschramke.checksum.algorithm

abstract class Algorithm(val params: Params) {
    internal val table = calculateLookupTable(params)

    abstract fun calculate(data: ByteArray, offset: Int = 0, length: Int = data.size): Long

    /**
     * @property name The name of the given algorithm.
     * @property width The size of the generated checksum.
     * @property generator The generator polynomial.
     * @property seed The initial value of the register on algorithm start.
     * @property reflectedIn
     * @property reflectedOut
     * @property xorOut
     * @property check A check value that can be used as a weak validator of implementations of the algorithm.
     */
    data class Params(
        val name: String,
        val width: Int,
        val generator: Long,
        val seed: Long,
        val reflectedIn: Boolean,
        val reflectedOut: Boolean,
        val xorOut: Long,
        val check: Long = 0x00
    ){
        init {
            if(width !in 1..64) {
                throw IllegalArgumentException("Parameter width must be in range 1 to 64! Given value is $width")
            }
        }

        val msb = (1L shl (width-1))
        val mask = if (width < 64) (1L shl width)-1 else -0x1L
    }

    companion object {
        fun create(params: Params):Algorithm = if(params.reflectedOut) RefOutAlgorithm(params) else NoRefOutAlgorithm(params)
    }
}