package com.example.praksa

import android.util.Log
import androidx.compose.runtime.collectAsState
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.praksa.network.RandomSlikaRepo
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject
//cela biznis loigka je ovde
@HiltViewModel
class MainActivityViewModel @Inject constructor(
    private val randomSlikaRepo: RandomSlikaRepo
): ViewModel() {

    init {
        fetchData()
    }

    //TODO sta je mutableStateflow
    private val _appState = MutableStateFlow(AppState.initial(null))
    val appState: StateFlow<AppState> = _appState.asStateFlow()


    fun updateLabela(unos: String){

        _appState.value = _appState.value.copy(textLabele = unos)
        Log.d("unos", "${_appState.value.textLabele}")
    }

    fun selectPage(page: AppState.Navigation.Page) {
        _appState.update {
            return@update it.copy(
                navigation = it.navigation.copy(
                    selectedPage = page
                )
            )
        }
    }
    fun fetchData() = viewModelScope.launch {
        val slikaa = randomSlikaRepo.getRandomSliku()

        _appState.value= _appState.value.copy(randSlika = slikaa)
        Log.e("RESPONSE", slikaa?.toString() ?: "failed to fetch")
    }

}

