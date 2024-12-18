package com.example.praksa

import android.annotation.SuppressLint
import android.util.Log

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.LineHeightStyle
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.navigation
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navigation
import androidx.navigation.toRoute
import com.example.praksa.drugiEkran.DrugiEkran
import com.example.praksa.drugiEkran.DrugiEkranViewModel
import com.example.praksa.ununosTekstaEkran.UnosTeksaScreen
import com.example.praksa.ununosTekstaEkran.UnosTekstaViewModel
import kotlinx.serialization.Serializable

@OptIn(ExperimentalMaterial3Api::class)
@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable //moze da se menja utunura sebe
fun RandomSlikaApp(
//    viewModel: MainActivityViewModel = viewModel()
//     viewModel: UnosTekstaViewModel = viewModel()
){
    val navController = rememberNavController()
//    val appState by viewModel.unosTekstaState.collectAsState()

    Log.d("blaa"," iza fetch")

    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text("Navigacija") },
                actions = {

//                    Button(onClick = { navController.navigate(UnosTekstaDestination) }) {
//                        Text(text = "Unos Teksta")
//                    }
//
//
//                    Button(onClick = { navController.navigate(DrugiEkranDestination(tekst = "")) }) { //viewModel.unosTekstaState.value.textLabele
//                        Text(text = "Drugi Ekran")
//                    }
                },

            )
        }
    ) { innerPadding ->
        NavHost(
            navController = navController,
            startDestination = UnosTekstaGraph,
            modifier = Modifier
                .fillMaxSize()
                .padding(innerPadding)
        ) {//TODO: nested da se napravi
            unostTekstaGraph(navController)
//            composable<UnosTekstaDestination> {
//                val viewModel: UnosTekstaViewModel = hiltViewModel<UnosTekstaViewModel>()
//                val prviEkranState by viewModel.unosTekstaState.collectAsStateWithLifecycle()
//                //ovde se instancira view model i appState i onda se ovde prosledjuje
//                UnosTeksaScreen(prviEkranState) { tekst ->
//                    navController.navigate(
//                        DrugiEkranDestination(tekst = tekst)
//                    )
//                    viewModel.updateLabela(tekst)
//                }
//
//            }
//            composable<DrugiEkranDestination> {
//
//                val drugiEkranViewModel = hiltViewModel<DrugiEkranViewModel>()
//                val drugiEkranState by drugiEkranViewModel.drugiEkranState.collectAsState()
//                val args = it.toRoute<DrugiEkranDestination>()
//                drugiEkranViewModel.setText(args.tekst)
//
//                DrugiEkran(drugiEkranState){
//                    navController.navigate(UnosTekstaDestination)
//                }
//
//            }
        }
    }
}

fun NavGraphBuilder.unostTekstaGraph(navController:NavController){
    navigation<UnosTekstaGraph>(startDestination = UnosTekstaDestination){
        composable<UnosTekstaDestination> {
            val viewModel: UnosTekstaViewModel = hiltViewModel<UnosTekstaViewModel>()
            val prviEkranState by viewModel.unosTekstaState.collectAsStateWithLifecycle()
            //ovde se instancira view model i appState i onda se ovde prosledjuje
            UnosTeksaScreen(prviEkranState) { tekst ->
                viewModel.updateLabela(tekst)
                navController.navigate(
                    DrugiEkranDestination(tekst = tekst)
                )

            }

        }
        composable<DrugiEkranDestination> {

            val drugiEkranViewModel = hiltViewModel<DrugiEkranViewModel>()
            val drugiEkranState by drugiEkranViewModel.drugiEkranState.collectAsState()
            val args = it.toRoute<DrugiEkranDestination>()
            drugiEkranViewModel.setText(args.tekst)

            DrugiEkran(drugiEkranState){
                navController.navigate(UnosTekstaDestination)
            }

        }
    }
}

@Serializable
object UnosTekstaGraph


@Serializable
object UnosTekstaDestination


@Serializable
data class DrugiEkranDestination(
    val tekst: String
)
//TODO: safetype sa serialized objektima
//TODO: za svaki ekran odvojen appState i viewModel
//TODO: generisati slike na gptu
//TODO: na drugom ekranu prikazati ucitane slike iz resourcse filea
//TODO: 





