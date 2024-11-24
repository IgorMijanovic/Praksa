package com.example.praksa

import android.util.Log
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
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
import androidx.compose.ui.graphics.painter.BitmapPainter
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.compose.ui.graphics.asImageBitmap
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import com.example.praksa.navigation.HeaderNavigation

@Composable //moze da se menja utunura sebe
fun RandomSlikaApp(
    viewModel: MainActivityViewModel = viewModel() //TODO: pitaj za ovo
){
    val appState by viewModel.appState.collectAsState()

    Log.d("blaa"," iza fetch")
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(color = MaterialTheme.colorScheme.background)
    ) {
        Spacer(modifier = Modifier.height(50.dp))

        HeaderNavigation(
            navigation = appState.navigation,
            onClick = { viewModel.selectPage(it) }
        )

        val selectedPage = appState.navigation.selectedPage
        when(selectedPage.title){
            "Page 1" -> {
                UnosTeksaScreen(viewModel)
            }
            "Page 2" -> {
                DrugiEkran(viewModel)
            }
        }

//        UnosTeksaScreen(viewModel)

    }
}

