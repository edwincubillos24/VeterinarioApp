package com.edwinacubillos.veterinarioapp.ui.VaccineActivity

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.edwinacubillos.veterinarioapp.R
import com.edwinacubillos.veterinarioapp.model.Vaccine
import kotlinx.android.synthetic.main.item_vaccine_rv.view.*

class VaccineRVAdapter internal constructor(context: Context, vaccineList: ArrayList<Vaccine>) : RecyclerView.Adapter<VaccineRVAdapter.VaccineViewHolder>() {

    private val inflater: LayoutInflater = LayoutInflater.from(context)
    private var vaccineList = emptyList<Vaccine>()
    private val context: Context

    init{
        this.vaccineList = vaccineList
        this.context = context
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): VaccineRVAdapter.VaccineViewHolder {
        val itemView = inflater.inflate(R.layout.item_vaccine_rv, parent, false)
        return VaccineViewHolder(itemView,context)
    }

    override fun getItemCount() = vaccineList.size

    override fun onBindViewHolder(holder: VaccineRVAdapter.VaccineViewHolder, position: Int) {
        val vaccine = vaccineList[position]
        holder.setVaccine(vaccine)
    }

    class VaccineViewHolder(itemView: View, context: Context) : RecyclerView.ViewHolder(itemView){

        private val context: Context
        private var vaccine: Vaccine? = null

        init {
            this.context = context
        }

        fun setVaccine(vaccine: Vaccine) {
            this.vaccine = vaccine
            itemView.tv_name.text = context.getString(R.string.name_lb)+vaccine.name
            itemView.tv_dose.text = context.getString(R.string.dose_lb)+vaccine.dose
            itemView.tv_date.text = context.getString(R.string.date_lb)+vaccine.date
        }
    }
}