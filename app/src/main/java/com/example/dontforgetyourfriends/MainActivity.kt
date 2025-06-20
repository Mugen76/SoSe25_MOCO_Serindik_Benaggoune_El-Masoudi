package com.example.dontforgetyourfriends

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import com.example.dontforgetyourfriends.ui.screens.FriendListScreen
import com.example.dontforgetyourfriends.ui.theme.DontForgetYourFriendsTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        setContent {
            DontForgetYourFriendsTheme {
                // 👉 Start-Screen eurer App
                FriendListScreen()
            }
        }
    }
}