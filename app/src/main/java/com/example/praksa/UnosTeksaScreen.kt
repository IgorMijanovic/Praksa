package com.example.praksa

import android.annotation.SuppressLint
import android.util.Log
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.asImageBitmap
import androidx.compose.ui.graphics.painter.BitmapPainter
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import com.google.firebase.Firebase
import com.google.firebase.analytics.analytics


@Composable
fun UnosTeksaScreen(
    viewModel: MainActivityViewModel,
//    appState: AppState
) {

    val appState by viewModel.appState.collectAsState()

    Card(
        colors = CardDefaults.cardColors(
            containerColor = MaterialTheme.colorScheme.primary,
        ),
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 20.dp, vertical = 50.dp)

    ) {
        //remember pamti stanje per recomposa, pamti state
        var searchText by remember { mutableStateOf("") }
        Log.d("blaa", " $searchText")


        Box(
            modifier = Modifier.padding(horizontal = 16.dp, vertical = 20.dp)
        ) {
            Column {
                appState.randSlika?.let { bitmap ->
                    Image(
                        painter = BitmapPainter(bitmap.asImageBitmap()),
                        contentDescription = null
                    )
                }
                Spacer(modifier = Modifier.height(50.dp))

                Text(
                    modifier = Modifier
                        .padding(horizontal = 16.dp),
                    text = "labela: ${appState.textLabele}",
                    maxLines = 3,
                    overflow = TextOverflow.Ellipsis,
                    style = MaterialTheme.typography.headlineSmall,
                )

                TextField(
                    value = searchText,
                    onValueChange = { searchText = it },
                    placeholder = { Text("Search") },

                    )

                Button(
                    onClick = {
                        Log.d("blad", " $searchText")
                        viewModel.updateLabela(searchText)
                        Firebase.analytics.logEvent("kliknuto_dugme", null)
                    },
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(top = 16.dp)
                ) {
                    Text(text = "sacuvaj")
                }
            }

        }


    }
}