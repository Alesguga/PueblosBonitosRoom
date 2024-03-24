package net.azarquiel.pueblosbonitos.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.squareup.picasso.Picasso
import net.azarquiel.pueblosbonitos.R
import net.azarquiel.pueblosbonitos.model.Pueblo
import net.azarquiel.pueblosbonitos.model.PuebloWithProvincia

/**
 * Created by pacopulido on 9/10/18.
 */
class AdapterPueblo(val context: Context,
                    val layout: Int
                    ) : RecyclerView.Adapter<AdapterPueblo.ViewHolder>() {

    private var dataList: List<PuebloWithProvincia> = emptyList()

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

    internal fun setPueblos(pueblos: List<PuebloWithProvincia>) {
        this.dataList = pueblos
        notifyDataSetChanged()
    }


    class ViewHolder(viewlayout: View, val context: Context) : RecyclerView.ViewHolder(viewlayout) {
        fun bind(dataItem: PuebloWithProvincia){
            // itemview es el item de diseño
            // al que hay que poner los datos del objeto dataItem
            val tvnombrerowpueblo = itemView.findViewById(R.id.tvnombrerowpueblo) as TextView
            val tvprovinciarowpueblo = itemView.findViewById(R.id.tvprovinciarowpueblo) as TextView
            val ivrowpueblo = itemView.findViewById(R.id.ivrowpueblo) as ImageView


            tvnombrerowpueblo.text = dataItem.pueblo.nombre
            tvprovinciarowpueblo.text = dataItem.provincia.nombre
            Picasso.get().load(dataItem.pueblo.imagen).into(ivrowpueblo)

            itemView.tag = dataItem

        }

    }
}