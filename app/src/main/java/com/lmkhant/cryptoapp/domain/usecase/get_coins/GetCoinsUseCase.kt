package com.lmkhant.cryptoapp.domain.usecase.get_coins

import com.lmkhant.cryptoapp.common.Resource
import com.lmkhant.cryptoapp.data.remote.dto.toCoin
import com.lmkhant.cryptoapp.data.repository.CoinRepository
import com.lmkhant.cryptoapp.domain.model.Coin
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import retrofit2.HttpException
import java.io.IOException
import javax.inject.Inject

class GetCoinsUseCase @Inject constructor(
    private val repository: CoinRepository
){
    operator fun invoke(): Flow<Resource<List<Coin>>> = flow {
        try {
            emit(Resource.Loading())
            val coins = repository.getCoins().map { it.toCoin() }
            emit(Resource.Success(coins))
        }catch (e: HttpException){
            emit(Resource.Error(e.localizedMessage?: "An expected error occurred"))
        }catch (e: IOException){
            emit(Resource.Error("Couldn't reach to server. Check your internet connection"))
        }
    }
}