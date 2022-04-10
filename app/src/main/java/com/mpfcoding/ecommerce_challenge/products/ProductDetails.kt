package com.mpfcoding.ecommerce_challenge.products

import android.os.Bundle
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import com.mpfcoding.ecommerce_challenge.R
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.product_details.*

class ProductDetails : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.product_details)

        val title = intent.getStringExtra("title") ?: ""

//        addToCartButton.setOnClickListener {
//
//        }

        availability.setOnClickListener {
            AlertDialog.Builder(this)
                .setMessage("Hey, $title is in stock!")
                .setPositiveButton("OK") { _, _ ->

                }
                .create()
                .show()
        }
    }
}
