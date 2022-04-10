package com.mpfcoding.ecommerce_challenge

import android.content.Intent
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.GravityCompat
import com.mpfcoding.ecommerce_challenge.cart.CartActivity
import com.mpfcoding.ecommerce_challenge.login.LoginActivity
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setSupportActionBar(toolbar)

        supportActionBar?.apply {
            setDisplayHomeAsUpEnabled(true)
            setHomeAsUpIndicator(R.drawable.ic_menu_white_24dp)
            title = ""
            this.elevation = 15F
        }

        supportFragmentManager.beginTransaction()
            .replace(R.id.frameLayout, MainFragment())
            .commit()

        navigationView.setNavigationItemSelectedListener {
            when (it.itemId) {
                R.id.actionCart -> {
                    startActivity(Intent(this, CartActivity::class.java))
                }
                R.id.actionHome -> {
                    //TODO("Logout")
                    startActivity(Intent(this, LoginActivity::class.java))
                }
            }
            it.isChecked = true
            drawerLayout.closeDrawers()
            true
        }
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if (item.itemId == R.id.actionCart) {
            startActivity(Intent(this, CartActivity::class.java))
            return true
        }
        drawerLayout.openDrawer(GravityCompat.START)
        return true
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu_toolbar, menu)
        return true
    }
}
