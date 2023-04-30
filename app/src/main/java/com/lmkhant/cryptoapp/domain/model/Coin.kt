package com.lmkhant.cryptoapp.domain.model

import com.lmkhant.cryptoapp.data.remote.dto.CoinDto

data class Coin(
    val id: String,
    val isActive: Boolean,
    val name: String,
    val rank: Int,
    val symbol: String,
)

fun CoinDto.toCoin():Coin{
    return Coin(id, isActive, name, rank, symbol)
}
