package com.example.praksa.drugiEkran

import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import javax.inject.Inject

@HiltViewModel
class DrugiEkranViewModel @Inject constructor(

): ViewModel() {

    private val _drugiEkranState = MutableStateFlow(DrugiEkranState.initial())
    val drugiEkranState: StateFlow<DrugiEkranState> = _drugiEkranState.asStateFlow()


    fun setText(textt:String){
        _drugiEkranState.value = _drugiEkranState.value.copy(tekst = textt)
    }

}