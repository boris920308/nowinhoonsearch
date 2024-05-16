package hoon.exam.nowinhoonsearch

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import hoon.exam.nowinhoonsearch.databinding.FragmentHomeBinding
import hoon.exam.nowinhoonsearch.network.NaverAPI
import hoon.exam.nowinhoonsearch.network.NaverSearchResponse
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class HomeFragment : Fragment() {

    private var _binding: FragmentHomeBinding? = null
    val binding get() = _binding!!


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentHomeBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.btnSearch.setOnClickListener {
            Log.d("hoon92", "click btnSearch")
            getSearchResult("book", binding.editText.text.toString())
        }
    }

    private fun getSearchResult(key: String, keyword: String) {
        Log.d("hoon92", "HomeFragment, getSearchResult, keyword = $keyword")
        NaverAPI.naverApiService.getSearch(key, keyword, 20, null)
            .enqueue(object : Callback<NaverSearchResponse> {
                override fun onResponse(
                    call: Call<NaverSearchResponse>,
                    response: Response<NaverSearchResponse>
                ) {
                    val result = response.body()
                    if (result != null && response.isSuccessful) {
                        Log.d("hoon92", "success, result = ${result.items}")
                    }
                }

                override fun onFailure(call: Call<NaverSearchResponse>, t: Throwable) {
                    Log.d("hoon92", "err, Msg = $t")
                }

            })
    }
}