package com.example.cifreiapk.model

import android.widget.TextView

class Cifra {
    var letraMusica = ""
    var nomeArtista = ""
    var nomeMusica = ""
    var tomSelecionado = ""

    constructor()

    constructor(tituloDaMusica: String, nomeDoArtista: String, letraDaMusica: String, nTom: String) {
        this.letraMusica = tituloDaMusica.toString()
        this.nomeArtista = nomeDoArtista.toString()
        this.nomeMusica = letraDaMusica.toString()
        this.tomSelecionado = nTom.toString()
    }
}