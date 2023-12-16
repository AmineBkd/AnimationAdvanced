package com.example.animationadvanced

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.navigation.compose.rememberNavController
import com.example.animationadvanced.view.AppNavigation
import com.example.animationadvanced.view.NavControllerProvider
import com.example.animationadvanced.view.Screens
import com.example.animationadvanced.view.theme.AnimationAdvancedTheme
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    @Inject
    lateinit var navControllerProvider: NavControllerProvider

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            AnimationAdvancedTheme {
                navControllerProvider.setController(rememberNavController())
                AppNavigation(navController = navControllerProvider.getController())
            }
        }
    }
}