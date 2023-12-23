package com.example.myapppabp

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide


class MortyAdapter (private val dataMorty: List<ResultsItem?>?) : RecyclerView.Adapter<MortyAdapter.MyViewHolder> () {
    class MyViewHolder (view: View) : RecyclerView.ViewHolder(view) {
        val imgMorty: ImageView = view.findViewById(R.id.item_image_Morty)
        val nameMorty: TextView = view.findViewById(R.id.item_name_morty)
        val statusMorty: TextView = view.findViewById(R.id.item_status_morty)
        val speciesMorty: TextView = view.findViewById(R.id.item_species_morty)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_row, parent, false)
        return MyViewHolder(view)
    }

    override fun getItemCount(): Int {
        if (dataMorty != null) {
            return dataMorty.size
        }
        return 0
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        //menampilkan
        holder.nameMorty.text = dataMorty?.get(position)?.name
        holder.statusMorty.text = dataMorty?.get(position)?.status
        holder.speciesMorty.text = dataMorty?.get(position)?.species

        Glide.with(holder.imgMorty)
            .load(dataMorty?.get(position)?.image)
            .error(R.drawable.ic_launcher_background)
            .into(holder.imgMorty)

        //Ketika di klik akan menampilkan toast sesuai nama
        holder.itemView.setOnClickListener{
            val name = dataMorty?.get(position)?.name
            Toast.makeText(holder.itemView.context, "${name}", Toast.LENGTH_SHORT).show()
        }
    }
}