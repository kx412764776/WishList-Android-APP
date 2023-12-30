package uk.android.wishlistapp

import android.content.Context
import androidx.room.Room
import uk.android.wishlistapp.data.WishDatabase
import uk.android.wishlistapp.data.WishRepository

object Graph {
    lateinit var database: WishDatabase

    val wishRepository by lazy {
        WishRepository(wishDao = database.wishDao())
    }

    fun provide(context: Context) {
        database = Room.databaseBuilder(
            context, WishDatabase::class.java, "wishlist.db")
            .build()
    }
}