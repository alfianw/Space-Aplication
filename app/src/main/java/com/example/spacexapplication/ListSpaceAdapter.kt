package com.example.spacexapplication

import Space
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class ListSpaceAdapter(private val listSpace: ArrayList<Space>) : RecyclerView.Adapter<ListSpaceAdapter.ListViewHolder>() {
    class ListViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val imgPhoto : ImageView = itemView.findViewById(R.id.img_item_photo)
        val tvName: TextView = itemView.findViewById(R.id.textName)
        val tvDescription: TextView = itemView.findViewById(R.id.textDes)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ListViewHolder {
        val view:View = LayoutInflater.from(parent.context).inflate(R.layout.card_space,parent,false)
        return ListViewHolder(view)
    }

    override fun getItemCount(): Int = listSpace.size

    override fun onBindViewHolder(holder: ListViewHolder, position: Int) {
        val (name, description, photo, average, character) = listSpace[position]
        holder.imgPhoto.setImageResource(photo!!)
        holder.tvName.text = name
        holder.tvDescription.text = description

        holder.itemView.setOnClickListener {
            val intent = Intent(it.context, SpaceDetailActivity::class.java)
            // Menggunakan ParcelableSpace agar nilai average dan character dapat dikirimkan
            val parcelableSpace = Space(name, description, photo, average, character)
            intent.putExtra("SPACE_EXTRA", parcelableSpace)
            it.context.startActivity(intent)
        }
    }

}