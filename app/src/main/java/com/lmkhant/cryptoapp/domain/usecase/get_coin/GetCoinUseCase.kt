package com.lmkhant.cryptoapp.domain.usecase.get_coin

import com.lmkhant.cryptoapp.common.Resource
import com.lmkhant.cryptoapp.data.remote.dto.toCoinDetail
import com.lmkhant.cryptoapp.data.repository.CoinRepository
import com.lmkhant.cryptoapp.domain.model.CoinDetail
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import retrofit2.HttpException
import java.io.IOException
import javax.inject.Inject

class GetCoinUseCase @Inject constructor(
    private val repository: CoinRepository
){
    operator fun invoke(coinId: String): Flow<Resource<CoinDetail>> = flow {
        try {
            emit(Resource.Loading())
            val coin = repository.getCoinById(coinId = coinId).toCoinDetail()
            emit(Resource.Success(coin))
        }catch (e: HttpException){
            emit(Resource.Error(e.localizedMessage?: "An expected error occurred"))
        }catch (e: IOException){
            emit(Resource.Error("Couldn't reach to server. Check your internet connection"))
        }
    }
}