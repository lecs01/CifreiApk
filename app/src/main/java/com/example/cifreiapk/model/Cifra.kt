package com.example.cifreiapk.model

import android.widget.TextView

class Cifra {
    var id = ""
    var letraMusica = ""
    var nomeArtista = ""
    var nomeMusica = ""
    var tomSelecionado = ""

    constructor()

    constructor(tituloDaMusica: String, nomeDoArtista: String, letraDaMusica: String, nTom: String) {
        this.letraMusica = letraDaMusica
        this.nomeArtista = nomeDoArtista
        this.nomeMusica = tituloDaMusica
        this.tomSelecionado = nTom
    }
}