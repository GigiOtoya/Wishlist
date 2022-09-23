package com.example.wishlist

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {

    lateinit var wishlists: WishlistAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Lookup the RecyclerView in activity layout
        val wishlistRv = findViewById<RecyclerView>(R.id.wishlistRv)
        wishlistRv.layoutManager = LinearLayoutManager(this)
        // Fetch list of wishlists
        val wishlistAdapter = WishlistAdapter(mutableListOf())
        // Attach the adapter to the RecyclerView to populate items
        wishlistRv.adapter = wishlistAdapter
        // On submit event handler
        val addWishlistBtn = findViewById<Button>(R.id.addWishlistBtn)

        addWishlistBtn.setOnClickListener {
            val nameEt = findViewById<EditText>(R.id.nameEditText)
            val priceEt = findViewById<EditText>(R.id.priceEditText)
            val urlEt = findViewById<EditText>(R.id.urlEditText)
            val name = nameEt.text.toString()
            val price = priceEt.text.toString()
            val url = urlEt.text.toString()

            if (name.isNotEmpty() && price.isNotEmpty() && url.isNotEmpty()) {
                // Create new wishlist item
                val wishlist = Wishlist(name, price, url)
                wishlistAdapter.addWishlist(wishlist)
            }
            // Clear Input Fields
            nameEt.text.clear()
            priceEt.text.clear()
            urlEt.text.clear()
        }
    }
}