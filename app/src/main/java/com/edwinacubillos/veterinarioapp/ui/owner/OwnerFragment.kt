package com.edwinacubillos.veterinarioapp.ui.owner

import android.app.AlertDialog
import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.edwinacubillos.veterinarioapp.R
import com.edwinacubillos.veterinarioapp.model.Owner
import com.edwinacubillos.veterinarioapp.ui.owner_detail.OwnerDetailActivity
import com.edwinacubillos.veterinarioapp.ui.owner_new.OwnerNewActivity
import com.edwinacubillos.veterinarioapp.utils.Constants
import com.google.android.material.floatingactionbutton.FloatingActionButton

class OwnerFragment : Fragment(), OwnerRVAdapter.OnItemClickListener,
    OwnerRVAdapter.OnLongClickListener {

    private lateinit var ownerViewModel: OwnerViewModel

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        val root = inflater.inflate(R.layout.fragment_owner, container, false)

        val fab: FloatingActionButton = root.findViewById(R.id.fab)
        val recyclerView = root.findViewById<RecyclerView>(R.id.rv_owner)
        recyclerView.layoutManager = LinearLayoutManager(activity!!.applicationContext)

        ownerViewModel = ViewModelProviders.of(this).get(OwnerViewModel::class.java)

        ownerViewModel.allOwner.observe(this, Observer { ownerList ->
            ownerList?.let {
                val adapter = OwnerRVAdapter(
                    activity!!.applicationContext,
                    it as ArrayList<Owner>,
                    this,
                    this
                )
                recyclerView.adapter = adapter
            }
        })

        fab.setOnClickListener {
            val intent = Intent(activity?.applicationContext, OwnerNewActivity::class.java)
            startActivity(intent)
        }
        return root
    }

    override fun onItemClick(owner: Owner) {
        val intent = Intent(activity!!.applicationContext, OwnerDetailActivity::class.java)
        intent.putExtra(Constants.OWNER, owner)
        startActivity(intent)
    }

    override fun onLongClick(owner: Owner) {
        val alertDialog: AlertDialog? = activity?.let {
            val builder = AlertDialog.Builder(it)
            builder.apply {
                setMessage(R.string.erase_pet_msg_)
                setPositiveButton(
                    R.string.accept
                ) { dialog, id ->
                    ownerViewModel.deletePetOwner(owner.id)
                    ownerViewModel.deleteOwner(owner)
                }
                setNegativeButton(
                    R.string.cancel
                ) { dialog, id ->
                }
            }
            builder.create()
        }
        alertDialog?.show()
    }
}
