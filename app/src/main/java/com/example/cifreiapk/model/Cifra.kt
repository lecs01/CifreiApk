package com.example.cifreiapk.model

import android.widget.TextView

class Cifra {
    var tituloDaMusica = ""
    var nomeDoArtista = ""
    var letraDaMusica = ""
    var nTom = ""

    constructor()

    constructor(tituloDaMusica: TextView?, nomeDoArtista: TextView?, letraDaMusica: TextView?, nTom: TextView?) {
        this.tituloDaMusica = tituloDaMusica.toString()
        this.nomeDoArtista = nomeDoArtista.toString()
        this.letraDaMusica = letraDaMusica.toString()
        this.nTom = nTom.toString()
    }
}