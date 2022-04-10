package com.mpfcoding.ecommerce_challenge.products

import android.app.AlertDialog
import android.app.Dialog
import android.content.Intent
import android.os.Bundle
import android.view.Window
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import com.mpfcoding.ecommerce_challenge.R
import com.mpfcoding.ecommerce_challenge.cart.CartActivity
import com.mpfcoding.ecommerce_challenge.model.Product
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.dialog_sum_products.*
import kotlinx.android.synthetic.main.product_details.*

class ProductDetails : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.product_details)

        val myProduct = intent.getSerializableExtra("my_product") as Product

        Picasso.get().load(myProduct.photoUrl).into(photo)
        product_name.text = myProduct.title
        thePriceOfProduct.text = "$ ${myProduct.price}"

        addToCartButton.setOnClickListener {
            startActivity(Intent(this, CartActivity::class.java))
            // TODO("Corrigir dialogo para adicionar item ao carrinho")
            //dialodChartProducts()
        }
    }

    private fun dialodChartProducts() {
        val dialog = AlertDialog.Builder(applicationContext)
        val inflater = layoutInflater.inflate(R.layout.dialog_sum_products, null)
        dialog.setView(inflater)
        dialog.setCancelable(false)
        val buttonOk = findViewById<Button>(R.id.button_add_in_chart)
        val buttonNo = findViewById<Button>(R.id.button_cancel_dialog)
        buttonOk.setOnClickListener {

        }
        buttonNo.setOnClickListener {

        }
        dialog.show()
    }
}

