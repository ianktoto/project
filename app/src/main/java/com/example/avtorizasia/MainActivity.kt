package com.example.avtorizasia

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        val userEmail: EditText = findViewById(R.id.user_email_auth)
        val userPass: EditText = findViewById(R.id.user_pass_auth)
        val userPass1: EditText = findViewById(R.id.user_pass1)
        val button: Button = findViewById(R.id.button_reg)

        button.setOnClickListener{
            val email = userEmail.text.toString().trim()
            val pass = userPass.text.toString().trim()
            val pass1 = userPass1.text.toString().trim()
            val  linkToAuth: TextView = findViewById(R.id.link_to_auth)

            linkToAuth.setOnClickListener {
                val intent = Intent(this, AuthActivity::class.java)
                startActivity(intent)
            }

            if (email == "" || pass == "" || pass1 == "" )
                Toast.makeText(this, "Не все поля заполнены", Toast.LENGTH_LONG).show()
            else if(pass != pass1)
                Toast.makeText(this, "Пароли не совподают", Toast.LENGTH_LONG).show()
            else{
                val user = User( email, pass)

                val db = DbHelper(this, null)
                db.addUser(user)
                Toast.makeText(this,"Пользователь $email добавлен",Toast.LENGTH_LONG).show()

                userEmail.text.clear()
                userPass.text.clear()
                userPass1.text.clear()

                val intent = Intent(this, AuthActivity::class.java)

                intent.putExtra("email", email)
                intent.putExtra("pass", pass)

                this.startActivity(intent)


            }
        }

    }
}