package com.example.wishlist

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class WishlistAdapter (private val wishlists: MutableList<Wishlist>) : RecyclerView.Adapter<WishlistAdapter.ViewHolder>(){
    // Provide a direct reference to each of the views within a data item
    // Used to cache the views within the item layout for fast access
    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        // Your holder should contain a member variable for any view that will be set as you render
        // a row
        val nameTextView: TextView
        val priceTextView: TextView
        val urlTextView: TextView

        // We also create a constructor that accepts the entire item row
        // and does the view lookups to find each sub-view
        init {
            // Stores the itemView in a public final member variable that can be used
            // to access the context from any ViewHolder instance.
            nameTextView = itemView.findViewById(R.id.name)
            priceTextView = itemView.findViewById(R.id.price)
            urlTextView = itemView.findViewById(R.id.url)
        }
    }

    fun addWishlist(wishlist: Wishlist) {
        wishlists.add(wishlist)
        notifyItemInserted(wishlists.size-1)
    }
    fun deleteWishlist(wishlist: Wishlist) {
        wishlists.remove(wishlist)
        notifyItemRemoved(wishlists.size-1)
    }
    // ... constructor and member variables
    // inflate layout from xml and return holder
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val context = parent.context
        val inflater = LayoutInflater.from(context)
        // Inflate custom layout
        val contactView = inflater.inflate(R.layout.wishlist_item, parent, false)
        // return a new holder instance
        return ViewHolder(contactView)
    }

    // populate data into the item through holder
    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        // Get the data model based on position
        val wishlist: Wishlist = wishlists.get(position)
        // Set item views based on your views and data model
        holder.nameTextView.text = wishlist.name
        holder.priceTextView.text = wishlist.price.toString()
        holder.urlTextView.text = wishlist.url
    }

    override fun getItemCount(): Int {
        return wishlists.size
    }
}