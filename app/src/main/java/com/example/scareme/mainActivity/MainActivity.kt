package com.example.scareme.mainActivity

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.navigation.compose.rememberNavController
import com.example.scareme.ui.navigation.AppNavHost
import com.example.scareme.ui.theme.ScareMeTheme
import org.koin.androidx.viewmodel.ext.android.viewModel

class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ScareMeTheme {
                val navController = rememberNavController()
                AppNavHost(navController = navController)
            }
        }
    }
}


