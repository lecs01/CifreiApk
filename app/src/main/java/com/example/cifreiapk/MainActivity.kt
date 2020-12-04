package com.example.cifreiapk

import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.cifreiapk.model.Cifra
import com.example.cifreiapk.model.cifraAdapter
import com.firebase.ui.database.FirebaseRecyclerOptions
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase

class MainActivity : AppCompatActivity() {

    private lateinit var recyclerView: RecyclerView
    private lateinit var adapter: cifraAdapter
    private lateinit var mbase: DatabaseReference

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        // Create a instance of the database and get
        // its reference
        // Create a instance of the database and get
        // its reference
        mbase = FirebaseDatabase.getInstance().reference

        recyclerView = findViewById(R.id.recyclerViewCifras)

        // To display the Recycler view linearly

        // To display the Recycler view linearly
        recyclerView.setLayoutManager(
            LinearLayoutManager(this))

        // It is a class provide by the FirebaseUI to make a
        // query in the database to fetch appropriate data

        // It is a class provide by the FirebaseUI to make a
        // query in the database to fetch appropriate data
        val options: FirebaseRecyclerOptions<Cifra> = FirebaseRecyclerOptions.Builder<Cifra>()
            .setQuery(mbase, Cifra::class.java)
            .build()
        // Connecting object of required Adapter class to
        // the Adapter class itself
        // Connecting object of required Adapter class to
        // the Adapter class itself
        adapter = cifraAdapter(options)
        // Connecting Adapter class with the Recycler view*/
        // Connecting Adapter class with the Recycler view*/
        recyclerView.setAdapter(adapter)
    }

    // Function to tell the app to start getting
    // data from database on starting of the activity
    override fun onStart() {
        super.onStart()
        adapter.startListening()
    }

    // Function to tell the app to stop getting
    // data from database on stoping of the activity
    override fun onStop() {
        super.onStop()
        adapter.stopListening()
    }

    fun criarCifra(view: View) {
        val intent = Intent(this, CriarCifraActivity::class.java)
        startActivity(intent)
    }
}