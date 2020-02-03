package com.edwinacubillos.veterinarioapp.ui.pet

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.edwinacubillos.veterinarioapp.R
import com.edwinacubillos.veterinarioapp.model.Pet
import com.edwinacubillos.veterinarioapp.utils.Constants
import kotlinx.android.synthetic.main.item_rv.view.*

class PetRVAdapter internal constructor(
    context: Context,
    petList: ArrayList<Pet>,
    onItemClickListener: OnItemClickListener,
    onLongClickListener: OnLongClickListener
) : RecyclerView.Adapter<PetRVAdapter.PetViewHolder>() {

    private val inflater: LayoutInflater = LayoutInflater.from(context)
    private var petList = emptyList<Pet>()
    private val context: Context
    private var onItemClickListener: OnItemClickListener
    private var onLongClickListener: OnLongClickListener

    init {
        this.petList = petList
        this.context = context
        this.onItemClickListener = onItemClickListener
        this.onLongClickListener = onLongClickListener
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PetViewHolder {
        val itemView = inflater.inflate(R.layout.item_rv, parent, false)
        return PetViewHolder(itemView, context, onItemClickListener, onLongClickListener)
    }

    override fun getItemCount() = petList.size

    override fun onBindViewHolder(holder: PetViewHolder, position: Int) {
        val pet = petList[position]
        holder.bindPet(pet)
    }

    class PetViewHolder(
        itemView: View,
        context: Context,
        onItemClickListener: OnItemClickListener,
        onLongClickListener: OnLongClickListener
    ) : RecyclerView.ViewHolder(itemView), View.OnClickListener, View.OnLongClickListener {

        private val context: Context
        private var pet: Pet? = null
        private var onItemClickListener: OnItemClickListener
        private var onLongClickListener: OnLongClickListener

        init {
            this.context = context
            this.onItemClickListener = onItemClickListener
            this.onLongClickListener = onLongClickListener
        }

        fun bindPet(pet: Pet) {
            this.pet = pet
            itemView.tv_name.text = pet.name
            itemView.tv_id_or_age.text = context.getString(R.string.age_lb) + pet.age
            when (pet.kind) {
                Constants.DOG -> itemView.iv_picture.setImageResource(R.drawable.dog)
                Constants.CAT -> itemView.iv_picture.setImageResource(R.drawable.cat)
                else -> itemView.iv_picture.setImageResource(R.drawable.bird)
            }
            itemView.setOnClickListener(this)
            itemView.setOnLongClickListener(this)
        }

        override fun onClick(v: View?) {
            onItemClickListener.onItemClick(pet!!)
        }

        override fun onLongClick(v: View?): Boolean {
            onLongClickListener.onLongClick(pet!!)
            return true
        }
    }

    interface OnItemClickListener {
        fun onItemClick(pet: Pet)
    }

    interface OnLongClickListener {
        fun onLongClick(pet: Pet)
    }
}
