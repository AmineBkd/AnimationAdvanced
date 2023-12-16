package com.example.animationadvanced.view

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.animationadvanced.view.discussion.ChatScreen
import com.example.animationadvanced.view.home.HomeScreen
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class NavControllerProvider @Inject constructor() {
    private lateinit var navController: NavHostController

    fun setController(controller: NavHostController) {
        navController = controller
    }

    fun getController(): NavHostController {
        return navController
    }
}

//Very Simple Navigation
//DeepLinks not implemented
@Composable
fun AppNavigation(navController: NavHostController){
    NavHost(navController = navController, startDestination = Screens.HOME.name) {
        composable(Screens.HOME.name) { HomeScreen() }
        composable(Screens.CHAT.name) { ChatScreen() }
    }
}

enum class Screens {
    HOME, CHAT
}