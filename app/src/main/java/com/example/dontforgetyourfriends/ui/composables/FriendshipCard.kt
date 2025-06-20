package com.example.dontforgetyourfriends.ui.composables

import androidx.compose.foundation.layout.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Delete
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.tooling.preview.Preview

@Composable
fun FriendshipCard(
    friendName: String,
    treeLevel: Int,
    modifier: Modifier = Modifier,
    onDelete: (() -> Unit)? = null
) {
    Card(
        modifier = modifier
            .fillMaxWidth()
            .padding(horizontal = 16.dp, vertical = 8.dp),
        elevation = CardDefaults.cardElevation(defaultElevation = 4.dp)
    ) {
        Row(
            modifier = Modifier
                .padding(16.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Icon(
                imageVector = Icons.Default.Favorite,
                contentDescription = "Baum",
                modifier = Modifier.size(48.dp)
            )

            Spacer(Modifier.width(16.dp))

            Column(modifier = Modifier.weight(1f)) {
                Text(text = friendName, style = MaterialTheme.typography.titleMedium)
                Text(text = "Baum-Level $treeLevel", style = MaterialTheme.typography.bodySmall)
            }

            if (onDelete != null) {
                IconButton(onClick = onDelete) {
                    Icon(
                        imageVector = Icons.Default.Delete,
                        contentDescription = "Löschen"
                    )
                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun FriendshipCardPreview() {
    FriendshipCard(
        friendName = "Max Mustermann",
        treeLevel = 3,
        onDelete = {}          // << jetzt wird der Button gezeichnet
    )
}