

package com.example.scareme.mainActivity

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.compose.rememberNavController
import com.example.scareme.ui.navigation.AppNavHost
import com.example.scareme.ui.navigation.NavigationItem
import com.example.scareme.ui.theme.ScareMeTheme
import org.koin.androidx.viewmodel.ext.android.viewModel

class MainActivity : ComponentActivity() {

    private val viewModel: MainActivityViewModel by viewModel()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            val isUserSignedIn by viewModel.isUserSignedIn.collectAsState(initial = false)
             //val startDestination = if (isUserSignedIn) NavigationItem.Home else NavigationItem.Splash
            val startDestination=NavigationItem.Splash
            // Log the value for debugging
            println("MainActivity - isUserSignedIn: $isUserSignedIn")

            ScareMeTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    val navController = rememberNavController()
                    AppNavHost(
                        modifier = Modifier.padding(innerPadding),
                        navController = navController,
                        startDestination = startDestination
                    )
                }
            }
        }
    }
}


