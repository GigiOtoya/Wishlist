package com.example.wishlist

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {

    lateinit var wishlists: List<Wishlist>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Lookup the RecyclerView in activity layout
        val wishlistRv = findViewById<RecyclerView>(R.id.wishlistRv)
        // Fetch list of wishlists

    }
}