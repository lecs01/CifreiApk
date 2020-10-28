package com.example.cifreiapk

import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity

class CreateTwo : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.create_two)

    }

    fun voltarEdicao(view: View){
        val intent = Intent (this, CreateOne::class.java)
        startActivity(intent)

    }
}