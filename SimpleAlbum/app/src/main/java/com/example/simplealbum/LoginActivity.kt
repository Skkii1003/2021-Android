package com.example.simplealbum

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.*
import androidx.core.widget.addTextChangedListener

class LoginActivity : AppCompatActivity() {

    private val TAG = "SignInActivity"


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        supportActionBar?.title = "SimpleAlbum"

        val etEmail = findViewById<EditText>(R.id.editText)
        etEmail.addTextChangedListener {
            Log.d(TAG, "The email user input: ${it}")
        }

        val etPassword = findViewById<EditText>(R.id.editText2)
        etPassword.addTextChangedListener {
            Log.d(TAG, "The password user input: ${it}")
        }

        findViewById<TextView>(R.id.textView3).setOnClickListener {
            val intent = Intent(this, ForgetActivity::class.java)
            startActivity(intent)
        }

        findViewById<Button>(R.id.button).setOnClickListener{
            val progressBar = findViewById<ProgressBar>(R.id.progressBar)
            val progressBarMask = findViewById<View>(R.id.progressBarMask)

            progressBar.visibility = View.VISIBLE
            progressBarMask.visibility = View.VISIBLE

            it.postDelayed({
                progressBar.visibility = View.GONE
                progressBarMask.visibility = View.GONE

                val email = etEmail.text.toString()
                val password = etPassword.text.toString()
                val user = UserCenter.getUserByEmail(email)

                if (user != null && user.password == password) {
                    Toast.makeText(this, R.string.login_sign_in_susscess_tip, Toast.LENGTH_SHORT)
                        .show()
                    UserCenter.signInUser = user
                    val intent = Intent(this, AlbumActivity::class.java)
                    startActivity(intent)
                    finish()
                }
                else {
                    Toast.makeText(this, R.string.login_sign_in_failure_tip, Toast.LENGTH_SHORT)
                        .show()
                }
            },2000)
        }

        findViewById<Button>(R.id.button2).setOnClickListener {
            val uri = Uri.parse("https://www.google.com/account")
            val intent = Intent(Intent.ACTION_VIEW, uri)
            startActivity(intent)
        }

        findViewById<TextView>(R.id.textView5).setOnClickListener {
            val intent = Intent(this, SignUpActivity::class.java)
            startActivity(intent)
        }
    }
}