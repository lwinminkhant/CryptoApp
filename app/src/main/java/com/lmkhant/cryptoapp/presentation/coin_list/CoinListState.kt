package com.lmkhant.cryptoapp.presentation.coin_list

import com.lmkhant.cryptoapp.domain.model.Coin

data class CoinListState(
    val isLoading: Boolean = false,
    val coins: List<Coin> = emptyList(),
    val error: String = ""
)