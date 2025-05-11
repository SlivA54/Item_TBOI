package com.example.itemtboi

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class CollectibleAdapter(
    private val items: List<Collectible>,
    private val context: Context
) : RecyclerView.Adapter<CollectibleAdapter.ViewHolder>() {

    inner class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val imageIcon: ImageView = view.findViewById(R.id.imageIcon)
        val textId: TextView = view.findViewById(R.id.textId)
        val textName: TextView = view.findViewById(R.id.textName)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_collectible, parent, false)
        return ViewHolder(view)
    }

    override fun getItemCount() = items.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val collectible = items[position]
        holder.textId.text = "ID: ${collectible.id}"
        holder.textName.text = collectible.name

        // Загрузка изображения по имени файла (id)
        val imageName = collectible.id.toString()
        val imageResId = context.resources.getIdentifier(imageName, "drawable", context.packageName)
        if (imageResId != 0) {
            holder.imageIcon.setImageResource(imageResId)
        } else {
            // Если изображение не найдено, можно поставить заглушку

        }
    }
}
