package com.example.praksa.drugiEkran

data class DrugiEkranState (
    val tekst: String
){


    companion object{
        fun initial(): DrugiEkranState {
            return DrugiEkranState(
                tekst = ""
            )
        }
    }

}