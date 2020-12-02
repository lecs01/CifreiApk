package com.example.cifreiapk.model

class Cifra {
    var nomeMusica = ""
    var nomeArtista = ""
    var letraMusica = ""
    var tomSelecionado = ""

    constructor()

    constructor(nomeMusica: String, nomeArtista: String, letraMusica: String, tomSelecionado: String) {
        this.nomeMusica = nomeMusica
        this.nomeArtista = nomeArtista
        this.letraMusica = letraMusica
        this.tomSelecionado = tomSelecionado
    }
}