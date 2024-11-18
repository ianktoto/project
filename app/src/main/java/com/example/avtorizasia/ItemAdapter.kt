package com.example.avtorizasia

import android.content.Context
import android.content.Intent
import android.graphics.Color
import android.os.Build
import android.text.style.BackgroundColorSpan
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.core.graphics.toColor
import androidx.core.graphics.toColorLong
import androidx.recyclerview.widget.RecyclerView

class ItemAdapter(var items: List<Item>, var context: Context ): RecyclerView.Adapter<ItemAdapter.MyViewHolder>() {
    class MyViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val avto: TextView = view.findViewById(R.id.item_list_avto)
        val yers: TextView = view.findViewById(R.id.item_list_year)
        val mileage: TextView = view.findViewById(R.id.item_list_mileage)
        val fuel: TextView = view.findViewById(R.id.item_list_fuel)
        val itemViewLayout: View = view.findViewById(R.id.item_list_layout)
        val btn: Button = view.findViewById(R.id.item_list_button)
    }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_in_list, parent, false)
        return MyViewHolder(view)
    }

    override fun getItemCount(): Int {
        return items.count()
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        holder.avto.text = items[position].avto
        holder.yers.text = items[position].year
        holder.mileage.text = items[position].mileage.toString()
        holder.fuel.text = items[position].fuel


        val color = when (items[position].fuel) {
            "Дизель" -> Color.YELLOW
            "Бензин" -> Color.RED
            "Гибрид" -> Color.GREEN
            "Электро" -> Color.GRAY
            else -> Color.WHITE // Default color
        }

        holder.itemViewLayout.setBackgroundColor(color)


        holder.btn.setOnClickListener {
            val intent = Intent(context, IteActivity::class.java)

            intent.putExtra("itemTitle", items[position].avto)
            intent.putExtra("itemYear", items[position].year)
            intent.putExtra("itemFuel", items[position].fuel)
            intent.putExtra("itemMileage", items[position].mileage)
            intent.putExtra("itemText", items[position].text)

            context.startActivity(intent)
        }
    }
}


