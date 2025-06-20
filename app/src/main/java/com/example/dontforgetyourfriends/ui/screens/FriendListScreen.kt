package com.example.dontforgetyourfriends.ui.screens

import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.dontforgetyourfriends.ui.composables.AddFriendDialog
import com.example.dontforgetyourfriends.ui.composables.AddFriendFab
import com.example.dontforgetyourfriends.ui.composables.FriendshipCard

@Composable
fun FriendListScreen() {
    // Zustand für Freundesliste
    val friends = remember { mutableStateListOf<Pair<String, Int>>() }

    // Zustand für Dialoganzeige
    var showDialog by remember { mutableStateOf(false) }

    // Testdaten beim ersten Start
    LaunchedEffect(Unit) {
        if (friends.isEmpty()) {
            friends.addAll(
                listOf(
                    "Max" to 3,
                    "Sophie" to 4,
                    "Ali" to 2
                )
            )
        }
    }

    Scaffold(
        floatingActionButton = {
            AddFriendFab(onAdd = { showDialog = true })
        }
    ) { innerPadding ->
        LazyColumn(
            contentPadding = innerPadding,
            modifier = Modifier.padding(horizontal = 8.dp, vertical = 4.dp)
        ) {
            itemsIndexed(friends) { index, (name, level) ->
                FriendshipCard(
                    friendName = name,
                    treeLevel  = level,
                    onDelete   = { friends.removeAt(index) }   // 🗑️ Eintrag entfernen
                )
            }
        }

        if (showDialog) {
            AddFriendDialog(
                onConfirm = { name ->
                    friends.add(name to 3) // Neue Freundschaft beginnt mit Level 3
                    showDialog = false
                },
                onDismiss = { showDialog = false }
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun FriendListScreenPreview() {
    FriendListScreen()
}