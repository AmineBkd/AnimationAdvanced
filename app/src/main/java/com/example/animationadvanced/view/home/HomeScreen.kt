package com.example.animationadvanced.view.home

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.animationadvanced.model.home.User
import com.example.animationadvanced.view.Screens
import com.example.animationadvanced.view.home.component.Profile
import com.example.animationadvanced.view.widget.AppBar
import com.example.animationadvanced.viewmodel.home.HomeViewModel


@Composable
@Preview
fun HomeScreen(){
    val homeScreenViewModel: HomeViewModel = hiltViewModel()
    val userProfileState: User? by homeScreenViewModel.user.observeAsState()

    Surface {
        Scaffold(topBar = { AppBar("Home") }, modifier = Modifier.fillMaxSize()) { innerPadding ->
            Column(modifier = Modifier.padding(innerPadding)) {
                Profile()
            }
        }
    }
}