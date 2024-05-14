package hoon.exam.nowinhoonsearch

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.navigation.NavController
import androidx.navigation.NavHost
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.setupWithNavController
import com.google.android.material.bottomnavigation.BottomNavigationView
import hoon.exam.nowinhoonsearch.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    private lateinit var bottomNavigation: BottomNavigationView
    private lateinit var navHostFragment: NavHostFragment
    private lateinit var navController: NavController
    private lateinit var appBarConfiguration: AppBarConfiguration

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        initNavigation()
    }

    private fun initNavigation() {
        bottomNavigation = binding.bottomNav
        navHostFragment = supportFragmentManager.findFragmentById(R.id.frag_container) as NavHostFragment
        navController =navHostFragment.navController
        appBarConfiguration = AppBarConfiguration(navController.graph)

        bottomNavigation.setupWithNavController(navController)
        bottomNavigation.setOnItemSelectedListener { item ->
            when (item.itemId) {
                R.id.homeFragment -> {
                    Log.d("MainActivity", "onNavigationItemSelected, item = homeFragment")
                    moveFragment(R.id.action_global_homeFragment)
                }

                R.id.favoriteFragment -> {
                    Log.d("MainActivity", "onNavigationItemSelected, item = favoriteFragment")
                    moveFragment(R.id.action_global_favoriteFragment)
                }

                R.id.myPageFragment -> {
                    Log.d("MainActivity", "onNavigationItemSelected, item = myPageFragment")
                    moveFragment(R.id.action_global_myPageFragment)
                }
            }
            false
        }
    }

    private fun moveFragment(action: Int) {
        navController.navigate(action)
    }
}