package net.azarquiel.pueblosbonitos.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import net.azarquiel.pueblosbonitos.R
import net.azarquiel.pueblosbonitos.model.Comunidad

/**
 * Created by pacopulido on 9/10/18.
 */
class AdapterComunidad(val context: Context,
                    val layout: Int
                    ) : RecyclerView.Adapter<AdapterComunidad.ViewHolder>() {

    private var dataList: List<Comunidad> = emptyList()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val viewlayout = layoutInflater.inflate(layout, parent, false)
        return ViewHolder(viewlayout, context)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = dataList[position]
        holder.bind(item)
    }

    override fun getItemCount(): Int {
        return dataList.size
    }

    internal fun setComunidades(comunidades: List<Comunidad>) {
        this.dataList = comunidades
        notifyDataSetChanged()
    }


    class ViewHolder(viewlayout: View, val context: Context) : RecyclerView.ViewHolder(viewlayout) {
        fun bind(dataItem: Comunidad){
            // itemview es el item de diseño
            // al que hay que poner los datos del objeto dataItem
            val tvrowcomunidad = itemView.findViewById(R.id.tvrowcomunidad) as TextView

            tvrowcomunidad.text = dataItem.nombre

            itemView.tag = dataItem

        }

    }
}