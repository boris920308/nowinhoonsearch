package hoon.exam.nowinhoonsearch

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import hoon.exam.nowinhoonsearch.network.NaverAPI
import hoon.exam.nowinhoonsearch.network.NaverSearchResponse
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.asSharedFlow
import kotlinx.coroutines.launch

class HomeViewModel : ViewModel() {

    private val _searchFlow = MutableSharedFlow<NaverSearchResponse>()
    val searchFlow = _searchFlow.asSharedFlow()

    fun getSearchResult(key: String, keyword: String) {
        Log.d("hoon92", "HomeViewModel, getSearchResult, keyword = $keyword")
        viewModelScope.launch {
            try {
                _searchFlow.emit(NaverAPI.naverApiService.getSearch(key, keyword, 20, null))
            } catch (e: Exception) {
                Log.e("hoon92", "err, Msg = e")
            }
        }
    }
}