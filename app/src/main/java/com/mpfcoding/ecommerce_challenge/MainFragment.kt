package com.mpfcoding.ecommerce_challenge

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.core.app.ActivityOptionsCompat
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.GridLayoutManager
import com.mpfcoding.ecommerce_challenge.model.Product
import com.mpfcoding.ecommerce_challenge.products.ProductDetails
import com.mpfcoding.ecommerce_challenge.products.ProductsAdapter
import kotlinx.android.synthetic.main.fragment_main.*

class MainFragment : androidx.fragment.app.Fragment() {

    lateinit var viewModel: MainFragmentViewModel

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_main, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewModel = ViewModelProviders.of(requireActivity())[MainFragmentViewModel::class.java]

        viewModel.products.observe(requireActivity()) {
            loadRecyclerView(it)
        }

        viewModel.setup()
    }

    private fun loadRecyclerView(products: List<Product>) {
        recycler_view.apply {
            layoutManager = GridLayoutManager(activity, 2)

            adapter = ProductsAdapter(products) { extraTitle, teste, photoView ->

                val intent = Intent(activity, ProductDetails::class.java)
                intent.putExtra("title", extraTitle)

                val options = ActivityOptionsCompat.makeSceneTransitionAnimation(
                    activity as AppCompatActivity,
                    photoView,
                    "photoToAnimate"
                )
                startActivity(intent, options.toBundle())
            }

        }
        progressBar.visibility = View.GONE
    }
}
