package hoon.exam.nowinhoonsearch

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import hoon.exam.nowinhoonsearch.network.NaverAPI
import hoon.exam.nowinhoonsearch.network.NaverSearchResponse
import hoon.exam.nowinhoonsearch.network.NaverSearchResponseItem
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class HomeViewModel : ViewModel() {

    val searchResult = MutableLiveData<List<NaverSearchResponseItem>>()

    fun getSearchResult(key: String, keyword: String) {
        Log.d("hoon92", "HomeViewModel, getSearchResult, keyword = $keyword")
        NaverAPI.naverApiService.getSearch(key, keyword, 20, null)
            .enqueue(object : Callback<NaverSearchResponse> {
                override fun onResponse(
                    call: Call<NaverSearchResponse>,
                    response: Response<NaverSearchResponse>
                ) {
                    val result = response.body()
                    if (result != null && response.isSuccessful) {
                        Log.d("hoon92", "success, result = ${result.items}")
                        searchResult.postValue(result.items)
                    }
                }

                override fun onFailure(call: Call<NaverSearchResponse>, t: Throwable) {
                    Log.e("hoon92", "err, Msg = $t")
                }

            })
    }
}