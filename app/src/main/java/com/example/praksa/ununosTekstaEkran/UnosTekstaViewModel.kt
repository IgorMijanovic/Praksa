package com.example.praksa.ununosTekstaEkran

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.praksa.network.RandomSlikaRepo
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class UnosTekstaViewModel @Inject constructor(
    private val randomSlikaRepo: RandomSlikaRepo
    ): ViewModel() {

        init {
            fetchData()
        }


        private val _unosTekstaState = MutableStateFlow(UnosTekstaState.initial(null))
        val unosTekstaState: StateFlow<UnosTekstaState> = _unosTekstaState.asStateFlow()


        fun updateLabela(unos: String){

            _unosTekstaState.value = _unosTekstaState.value.copy(textLabele = unos)
            Log.d("unos", "${_unosTekstaState.value.textLabele}")
        }


        fun fetchData() = viewModelScope.launch {
            val slikaa = randomSlikaRepo.getRandomSliku()
//        Firebase.analytics.logEvent("ucitani podaci", null)
            _unosTekstaState.value= _unosTekstaState.value.copy(randSlika = slikaa)
            Log.e("RESPONSE", slikaa?.toString() ?: "failed to fetch")
        }
}