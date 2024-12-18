package com.example.praksa.ununosTekstaEkran

import android.graphics.Bitmap

data class UnosTekstaState(
    val navigation: Navigation,
    var randSlika: Bitmap?,
    var textLabele: String
){

    data class Navigation(
        val navItems: List<Page>,
        val selectedPage: Page
    ){
        data class Page(val title: String, val tekst: String)
    }

    companion object{    /// <------ svuda u kodu je dostupan. kao public. singleton
        fun initial(slika: Bitmap?): UnosTekstaState {
            val pages = buildList {
                add(Navigation.Page("Page 1", "strana1"))
                add(Navigation.Page("Page 2", "strana2"))
            }

//            val bitmap = BitmapFactory.decodeResource(context.resources, R.drawable.your_image)
            return UnosTekstaState(
                navigation = Navigation(
                    navItems = pages,
                    selectedPage = pages[0]
                ),
                textLabele = "",
                randSlika = slika
//
            )
        }
    }
}
