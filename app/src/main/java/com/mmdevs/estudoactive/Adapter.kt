package com.mmdevs.estudoactive


import android.media.Image
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.mmdevs.valorantapiapp.models.DataItem
import com.squareup.picasso.Picasso

class Adapter(
	private val listaAgentes: List<DataItem>,
	val nameSelected: (DataItem) -> Unit
):RecyclerView.Adapter<Adapter.MyViewHolder>() {


	override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
		val itemView = LayoutInflater.from(parent.context).inflate(R.layout.item_adapter,parent,false)
		return MyViewHolder(itemView)
	}

	override fun getItemCount() = listaAgentes.size

	override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
		val data = listaAgentes[position]
		holder.description.text = data.displayName

//		holder.description.text = data.description

		Picasso.get().load(data.displayIcon).into(holder.image)

		holder.itemView.setOnClickListener {nameSelected(data)}
	}

	class MyViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView){
//		val textName: TextView = itemView.findViewById(R.id.NameAgente)
		val description: TextView = itemView.findViewById(R.id.description)
		val image = itemView.findViewById<ImageView>(R.id.imageId)
	}
}