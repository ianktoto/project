package com.example.avtorizasia

import android.graphics.Color
import android.graphics.drawable.shapes.Shape
import android.os.Bundle
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import org.w3c.dom.Text
import java.lang.reflect.Modifier




class IteActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_ite)


        val avto: TextView = findViewById(R.id.item_list_title_one)
        val year: TextView = findViewById(R.id.item_list_text_two)
        val fuel: TextView = findViewById(R.id.item_list_text_there)
        val mileage: TextView = findViewById(R.id.item_list_text_four)
        val text: TextView = findViewById(R.id.item_list_text_five)


        avto.text = intent.getStringExtra("itemTitle")
        year.text = intent.getStringExtra("itemYear")
        fuel.text = intent.getStringExtra("itemFuel")
        mileage.text = intent.getStringExtra("itemMileage")
        text.text = intent.getStringExtra("itemText")

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }
}

