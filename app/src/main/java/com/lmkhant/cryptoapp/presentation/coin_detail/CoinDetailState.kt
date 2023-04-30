package com.lmkhant.cryptoapp.presentation.coin_detail

import com.lmkhant.cryptoapp.domain.model.Coin
import com.lmkhant.cryptoapp.domain.model.CoinDetail

data class CoinDetailState(
    val isLoading: Boolean = false,
    val coin: CoinDetail? = null,
    val error: String = ""
)