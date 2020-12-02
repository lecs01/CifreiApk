package com.example.cifreiapk.model

class Cifra {
    var nomeMusica = ""
    var nomeArtista = ""
    var letraMusica = ""
    var tomSelecionado = ""

    constructor()

    constructor(nomeMusica: String, nomeArtista: String, letraMusica: String, tomSelecionado: String) {
        this.nomeMusica = nomeMusica.toString()
        this.nomeArtista = nomeArtista.toString()
        this.letraMusica = letraMusica.toString()
        this.tomSelecionado = tomSelecionado.toString()
    }
}