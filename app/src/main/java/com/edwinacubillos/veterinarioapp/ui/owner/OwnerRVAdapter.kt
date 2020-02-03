package com.edwinacubillos.veterinarioapp.ui.owner

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.edwinacubillos.veterinarioapp.R
import com.edwinacubillos.veterinarioapp.model.Owner
import kotlinx.android.synthetic.main.item_rv.view.*

class OwnerRVAdapter internal constructor(
    context: Context,
    ownerList: ArrayList<Owner>,
    onItemClickListener: OnItemClickListener,
    onLongClickListener: OnLongClickListener
) :
    RecyclerView.Adapter<OwnerRVAdapter.OwnerViewHolder>() {

    private val inflater: LayoutInflater = LayoutInflater.from(context)
    private var ownerList = emptyList<Owner>()
    private val context: Context
    private var onItemClickListener: OnItemClickListener
    private var onLongClickListener: OnLongClickListener

    init {
        this.ownerList = ownerList
        this.context = context
        this.onItemClickListener = onItemClickListener
        this.onLongClickListener = onLongClickListener
    }

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): OwnerViewHolder {
        val itemView = inflater.inflate(R.layout.item_rv, parent, false)
        return OwnerViewHolder(itemView, context, onItemClickListener, onLongClickListener)
    }

    override fun getItemCount() = ownerList.size

    override fun onBindViewHolder(holder: OwnerViewHolder, position: Int) {
        val owner = ownerList[position]
        holder.bindOwner(owner)
    }

    class OwnerViewHolder(
        itemView: View,
        context: Context,
        onItemClickListener: OnItemClickListener,
        onLongClickListener: OnLongClickListener
    ) : RecyclerView.ViewHolder(itemView),
        View.OnClickListener, View.OnLongClickListener {

        private val context: Context
        private var owner: Owner? = null
        private var onItemClickListener: OnItemClickListener
        private var onLongClickListener: OnLongClickListener

        init {
            this.context = context
            this.onItemClickListener = onItemClickListener
            this.onLongClickListener = onLongClickListener
        }

        fun bindOwner(owner: Owner) {
            this.owner = owner
            itemView.tv_name.text = owner.name
            itemView.tv_id_or_age.text = context.getString(R.string.id_lb) + owner.id.toString()
            itemView.setOnClickListener(this)
            itemView.setOnLongClickListener(this)
        }

        override fun onClick(v: View?) {
            onItemClickListener.onItemClick(owner!!)
        }

        override fun onLongClick(v: View?): Boolean {
            onLongClickListener.onLongClick(owner!!)
            return true
        }
    }

    interface OnItemClickListener {
        fun onItemClick(owner: Owner)
    }

    interface OnLongClickListener {
        fun onLongClick(owner: Owner)
    }
}
