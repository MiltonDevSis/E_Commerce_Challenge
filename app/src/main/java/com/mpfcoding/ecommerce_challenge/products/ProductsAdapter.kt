package com.mpfcoding.ecommerce_challenge.products

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.mpfcoding.ecommerce_challenge.R
import com.mpfcoding.ecommerce_challenge.model.Product
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.product_row.view.*

class ProductsAdapter(
    private val products: List<Product>,
    private val onClickProduct: (title: String, photoUrl: String, price: Double, isSale: Boolean, photoView: View) -> Unit
) : RecyclerView.Adapter<ProductsAdapter.ViewHolder>() {

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val product = products[position]
        Picasso.get().load(product.photoUrl).into(holder.image)
        holder.title.text = product.title
        holder.price.text = "$ ${product.price}"

        if (product.isOnSale) {
            holder.saleImageView.visibility = View.VISIBLE
        } else {
            holder.saleImageView.visibility = View.GONE
        }

        holder.image.setOnClickListener {
            onClickProduct.invoke(product.title, product.photoUrl, product.price, product.isOnSale, holder.image)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.product_row, parent, false)
        return ViewHolder(view)
    }

    override fun getItemCount() = products.size

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val image: ImageView = itemView.findViewById(R.id.photo)
        val title: TextView = itemView.findViewById(R.id.title)
        val price: TextView = itemView.findViewById(R.id.price)
        val saleImageView: ImageView = itemView.saleImageView
    }
}