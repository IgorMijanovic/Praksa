package com.example.praksa.drugiEkran

import android.service.autofill.OnClickAction
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.LineHeightStyle
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.praksa.UnosTekstaDestination
import com.example.praksa.ununosTekstaEkran.UnosTekstaState

@Composable
fun DrugiEkran(
//    unosTekstaState: UnosTekstaState
//    tekst: String
    drugiEkranState: DrugiEkranState,
//    navController: NavController,
    nazad:() -> Unit //TODO: BOLJE OVAKO
//    nazad:(String) -> Unit
){


    Box(
        modifier = Modifier.padding(horizontal = 16.dp, vertical = 20.dp)
    ) {

        Text(
            modifier = Modifier
                .padding(horizontal = 16.dp),
            text = "labela: ${drugiEkranState.tekst}",
            maxLines = 3,
            overflow = TextOverflow.Ellipsis,
            style = MaterialTheme.typography.headlineSmall,
        )
        Button(
            onClick = nazad

            ,
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 16.dp)
        ) {
            Text("nazad")
        }
    }
}