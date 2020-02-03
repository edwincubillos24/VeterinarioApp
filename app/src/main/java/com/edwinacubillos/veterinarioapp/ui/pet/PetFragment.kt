package com.edwinacubillos.veterinarioapp.ui.pet

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
import com.edwinacubillos.veterinarioapp.model.Pet
import com.edwinacubillos.veterinarioapp.ui.pet_detail.PetDetailActivity
import com.edwinacubillos.veterinarioapp.ui.pet_new.PetNewActivity
import com.edwinacubillos.veterinarioapp.utils.Constants
import com.google.android.material.floatingactionbutton.FloatingActionButton

class PetFragment : Fragment(), PetRVAdapter.OnItemClickListener, PetRVAdapter.OnLongClickListener {

    private lateinit var petViewModel: PetViewModel

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        val root = inflater.inflate(R.layout.fragment_pet, container, false)

        val fab: FloatingActionButton = root.findViewById(R.id.fab)
        val recyclerView = root.findViewById<RecyclerView>(R.id.rv_pet)
        recyclerView.layoutManager = LinearLayoutManager(activity!!.applicationContext)

        petViewModel = ViewModelProviders.of(this).get(PetViewModel::class.java)

        petViewModel.allPet.observe(this, Observer { petList ->
            petList?.let {
                val adapter =
                    PetRVAdapter(activity!!.applicationContext, it as ArrayList<Pet>, this, this)
                recyclerView.adapter = adapter
            }
        })

        fab.setOnClickListener {
            val intent = Intent(activity?.applicationContext, PetNewActivity::class.java)
            startActivity(intent)
        }

        return root
    }

    override fun onItemClick(pet: Pet) {
        val intent = Intent(activity!!.applicationContext, PetDetailActivity::class.java)
        intent.putExtra(Constants.PET, pet)
        startActivity(intent)
    }

    override fun onLongClick(pet: Pet) {
        val alertDialog: AlertDialog? = activity?.let {
            val builder = AlertDialog.Builder(it)
            builder.apply {
                setMessage(R.string.erase_pet_msg_)
                setPositiveButton(
                    R.string.accept
                ) { dialog, id ->
                    petViewModel.deletePetVaccine(pet.id)
                    petViewModel.deletePet(pet)
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
