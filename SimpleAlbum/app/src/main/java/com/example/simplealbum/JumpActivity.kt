package com.example.simplealbum

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity

class JumpActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        if (UserCenter.signInUser != null) {
            startActivity(Intent(this, AlbumActivity::class.java))
        } else {
            startActivity(Intent(this, LoginActivity::class.java))
        }
        finish()
    }
}