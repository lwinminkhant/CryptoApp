package com.lmkhant.cryptoapp.presentation.coin_list

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.lmkhant.cryptoapp.common.Resource
import com.lmkhant.cryptoapp.domain.usecase.get_coin.GetCoinUseCase
import com.lmkhant.cryptoapp.domain.usecase.get_coins.GetCoinsUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class CoinListViewModel @Inject constructor(
    private val getCoinUseCase: GetCoinsUseCase
): ViewModel(){
    private val _state = mutableStateOf<CoinListState>(CoinListState())
    val state : State<CoinListState> = _state
    init {
        getCoins()
    }
    private fun getCoins(){
        getCoinUseCase().onEach {result ->
            when(result){
                is Resource.Success ->{
                    _state.value = CoinListState(coins = result.data ?: emptyList())
                }
                is Resource.Error ->{
                    _state.value = CoinListState(error = result.message ?: "")
                }
                is Resource.Loading -> {
                    _state.value = CoinListState(isLoading = true)
                }
            }
        }.launchIn(viewModelScope)
    }
}