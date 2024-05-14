package hoon.exam.nowinhoonsearch

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import hoon.exam.nowinhoonsearch.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }
}