package com.lmkhant.cryptoapp.domain.repository

import com.lmkhant.cryptoapp.data.remote.CoinPaprikaApi
import com.lmkhant.cryptoapp.data.remote.dto.CoinDetailDto
import com.lmkhant.cryptoapp.data.remote.dto.CoinDto
import com.lmkhant.cryptoapp.data.repository.CoinRepository
import javax.inject.Inject


class CoinRepositoryImpl @Inject constructor(
    private val api: CoinPaprikaApi
): CoinRepository{
    override suspend fun getCoins(): List<CoinDto> {
        return api.getCoins()
    }

    override suspend fun getCoinById(coinId: String): CoinDetailDto {
        return api.getCoinById(coinId)
    }
}