package com.example.avtorizasia

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.Recycler

class ItemActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_item)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val  itemsList: RecyclerView = findViewById(R.id.itemList)
        val items = arrayListOf<Item>()


        items.add(Item(1, "BMW", "2012", "Бензин", "23456","ekfbsekfbeskfjesujfhofhseufhsuofhseuhfujosefuosehfujoeshfujsehfujoeshfujosehfoueshfueshfoujsefsef"))
        items.add(Item(2, "KIA", "2003", "Дизель", "2136","s;kfmnslejfshjbfshbfshkbshgbsujbfesuhfsujenfjosebgjsrjsnvfljnlidzvnsdnvdlnjjbnjnjninindflknea"))
        items.add(Item(3, "AUDI", "1980", "Электро", "23456","jffnswejfnsejnfsjefnsoejfnsejfnesjbfljsebfljsenfljsenfljksenflsenflksenfksenflseknfslejkfnseljkfnseljkfnsleknflksenf"))
        items.add(Item(4, "LADA", "2008", "Гибрид", "345454","sefisuslnjnskfsfjsofuhseoufhoufbseoufsfuisehfuisefnselkfnslfljseefiselfnseoehfoisehfjlsnfjld"))
        items.add(Item(5, "Toyota", "2008", "Бензин", "676565","srfijseoifjsefjseoijfipesjfiesjfipesjfesijfesffghbjnjkodvikbnb malxpcvboi bkn,ldpjibhlewkjfe,.;f'l;bkvjoijfoiesjf"))



        itemsList.layoutManager = LinearLayoutManager(this)
        itemsList.adapter = ItemAdapter(items,this)


    }
}