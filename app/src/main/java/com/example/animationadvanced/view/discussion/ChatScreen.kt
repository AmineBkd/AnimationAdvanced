package com.example.animationadvanced.view.discussion

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.example.animationadvanced.view.widget.AppBar

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ChatScreen(){
    Surface {
        Scaffold(topBar = { AppBar("ChatScreen") }, modifier = Modifier.fillMaxSize()) { innerPadding ->
            Column(modifier = Modifier.padding(innerPadding)) {
                Text("ChatScreen")
            }
        }
    }
}