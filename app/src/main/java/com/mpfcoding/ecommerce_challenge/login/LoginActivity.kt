package com.mpfcoding.ecommerce_challenge.login

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase
import com.mpfcoding.ecommerce_challenge.MainActivity
import com.mpfcoding.ecommerce_challenge.R
import kotlinx.android.synthetic.main.activity_login.*

class LoginActivity : AppCompatActivity() {

    private lateinit var auth: FirebaseAuth

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        auth = Firebase.auth

        button_login.setOnClickListener {

            progressBar.visibility = View.VISIBLE

            if (validateValues()){
                val email = edit_document.text.toString()
                val password = edit_password.text.toString()

                auth.signInWithEmailAndPassword(email, password)
                    .addOnCompleteListener(this) { task ->
                        if (task.isSuccessful) {
                            startActivity(Intent(this, MainActivity::class.java))
                            progressBar.visibility = View.GONE
                        } else {
                            Toast.makeText(this, "User not find", Toast.LENGTH_SHORT).show()
                            progressBar.visibility = View.GONE
                        }
                    }
            }
        }
    }

    private fun validateValues(): Boolean{
        // TODO ("Implementar validacao de dados")
        return true
    }
}