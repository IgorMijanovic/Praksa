package com.example.praksa

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp

@Composable
fun DrugiEkran(
    appState: AppState
){


    Box(
        modifier = Modifier.padding(horizontal = 16.dp, vertical = 20.dp)
    ) {

        Text(
            modifier = Modifier
                .padding(horizontal = 16.dp),
            text = "labela: ${appState.textLabele}",
            maxLines = 3,
            overflow = TextOverflow.Ellipsis,
            style = MaterialTheme.typography.headlineSmall,
        )
    }
}