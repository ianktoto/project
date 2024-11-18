package com.example.avtorizasia

import android.content.ClipData.Item
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity

class AuthActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_auth)
//        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
//            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
//            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
//            insets
//        }
        val userEmail: EditText = findViewById(R.id.user_email_auth)
        val userPass: EditText = findViewById(R.id.user_pass_auth)
        val button: Button = findViewById(R.id.button_auth)
        val linkToReg: TextView = findViewById(R.id.link_to_auth)

        userEmail.setText(intent.getStringExtra("email"))
        userPass.setText(intent.getStringExtra("pass"))

        linkToReg.setOnClickListener {
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }

        button.setOnClickListener{
            val email = userEmail.text.toString().trim()
            val pass = userPass.text.toString().trim()
            val  linkToAuth: TextView = findViewById(R.id.link_to_auth)

            linkToAuth.setOnClickListener {
                val intent = Intent(this, AuthActivity::class.java)
                startActivity(intent)
            }

            if (email == "" || pass == ""  )
                Toast.makeText(this, "Не все поля заполнены", Toast.LENGTH_LONG).show()
            else{
                val db = DbHelper(this, null)
                val isAuth = db.getUser(email,pass)

                if(isAuth) {
                    Toast.makeText(this, "Пользователь $email авторизован", Toast.LENGTH_LONG).show()
                    userEmail.text.clear()
                    userPass.text.clear()

                    val intent = Intent(this, ItemActivity::class.java)
                    startActivity(intent)
                }else
                    Toast.makeText(this, "Пользователь $email НЕ авторизован", Toast.LENGTH_LONG).show()

            }
        }

    }
}