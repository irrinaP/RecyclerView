package com.example.recyclerview

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.view.menu.MenuView.ItemView
import androidx.recyclerview.widget.RecyclerView

class MyAdapter( private val context: Context, private val colorList: ArrayList<ColorData>, private val cellClickListener: CellClickListener
) : RecyclerView.Adapter<MyAdapter.myViewHolder>() {

    class myViewHolder(itemView: View): RecyclerView.ViewHolder(itemView){
        val myColorImg:View = itemView.findViewById(R.id.view_color)
        val myTextView: TextView = itemView.findViewById(R.id.textview)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): myViewHolder {
        val view = LayoutInflater.from(context).inflate(R.layout.rview_item, parent, false)
        return myViewHolder(view)
    }

    override fun onBindViewHolder(holder: myViewHolder, position: Int) {
       val data =  colorList[position]
        holder. myColorImg.setBackgroundColor(data.colorHex)
        holder.myTextView.text = data.colorName

        holder.itemView.setOnClickListener{
            cellClickListener.onCellClickListener(data)
        }
    }

    override fun getItemCount(): Int {
        return colorList.size
    }
}
