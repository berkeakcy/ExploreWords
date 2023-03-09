package com.example.englishwords

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.databinding.DataBindingUtil
import androidx.navigation.NavController
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.setupWithNavController
import com.example.englishwords.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private lateinit var  appbarConfiguration:AppBarConfiguration
    lateinit var navController: NavController

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //setContentView(R.layout.activity_main)
        binding = DataBindingUtil.setContentView(this,R.layout.activity_main)

        val navHostFragment = supportFragmentManager.findFragmentById(R.id.nav_host_fragment) as NavHostFragment
        navController = navHostFragment.navController
        navController.addOnDestinationChangedListener{_,destination,_ ->
            if(destination.id == R.id.homeFragment){
                binding.toolbar.visibility = View.GONE
            }
            else{
                binding.toolbar.visibility = View.VISIBLE
            }
        }
        appbarConfiguration = AppBarConfiguration(navController.graph)
        binding.toolbar.setupWithNavController(navController,appbarConfiguration)

    }
}