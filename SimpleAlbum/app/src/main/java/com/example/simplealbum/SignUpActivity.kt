package com.example.simplealbum

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.*
import androidx.core.widget.addTextChangedListener

class SignUpActivity : AppCompatActivity() {

    companion object {
        private const val TAG = "SignUpActivity"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sign_up)

        supportActionBar?.title = getString(R.string.album_app_name)

        var name = ""
        findViewById<EditText>(R.id.et_username).addTextChangedListener {
            name = it.toString()
        }

        var email = ""
        findViewById<EditText>(R.id.et_useremail).addTextChangedListener {
            email = it.toString()
        }

        var password = ""
        findViewById<EditText>(R.id.et_userpassword).addTextChangedListener {
            password = it.toString()
        }

        var age = 0
        findViewById<EditText>(R.id.et_userage).addTextChangedListener {
            age = it.toString().toInt()
        }

        var gender = ""
        findViewById<RadioGroup>(R.id.rg_usergender).setOnCheckedChangeListener { group, checkedId ->
            if (checkedId == R.id.rb_gender_male) {
                gender = "male"
            } else {
                gender = "female"
            }
        }

        var address = ""
        findViewById<EditText>(R.id.et_useraddress).addTextChangedListener {
            address = it.toString()
        }

        findViewById<Button>(R.id.btn_cancel).setOnClickListener {
            finish()
        }

        findViewById<TextView>(R.id.tv_licence).setOnClickListener {
            val uri = Uri.parse("https://www.bytedance.com")
            val intent = Intent(Intent.ACTION_VIEW, uri)
            startActivity(intent)
        }

        findViewById<Button>(R.id.btn_confirm).setOnClickListener {
            if (!findViewById<CheckBox>(R.id.cb_licence).isChecked) {
                Toast.makeText(this, R.string.signup_fail_not_agree_licence, Toast.LENGTH_SHORT)
                    .show()
            } else {
                if (name.isEmpty() || email.isEmpty() || password.isEmpty() || gender.isEmpty() || address.isEmpty()) {
                    Toast.makeText(this, R.string.signup_fail_data_invalid, Toast.LENGTH_SHORT)
                        .show()
                } else {
                    val user = User(name, email, password, age, gender, address)
                    UserCenter.addUser(user)
                    Toast.makeText(this, R.string.signup_success, Toast.LENGTH_SHORT).show()
                    finish()
                }
            }
        }
    }
}