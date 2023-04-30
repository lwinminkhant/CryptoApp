package com.lmkhant.cryptoapp.data.repository

import com.lmkhant.cryptoapp.data.remote.dto.CoinDetailDto
import com.lmkhant.cryptoapp.data.remote.dto.CoinDto

interface CoinRepository {
    suspend fun getCoins(): List<CoinDto>
    suspend fun getCoinById(coinId: String): CoinDetailDto
}