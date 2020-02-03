package com.edwinacubillos.veterinarioapp.ui.owner_detail

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.edwinacubillos.veterinarioapp.R
import com.edwinacubillos.veterinarioapp.model.Owner
import com.edwinacubillos.veterinarioapp.model.Pet
import com.edwinacubillos.veterinarioapp.ui.pet.PetRVAdapter
import com.edwinacubillos.veterinarioapp.ui.pet_detail.PetDetailActivity
import com.edwinacubillos.veterinarioapp.ui.pet_new.PetNewActivity
import com.edwinacubillos.veterinarioapp.utils.Constants
import kotlinx.android.synthetic.main.activity_owner_detail.*
import kotlinx.android.synthetic.main.content_owner_detail.*

class OwnerDetailActivity : AppCompatActivity(), PetRVAdapter.OnItemClickListener,
    PetRVAdapter.OnLongClickListener {

    private lateinit var ownerDetailViewModel: OwnerDetailViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_owner_detail)
        setSupportActionBar(toolbar)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        val owner = intent?.getSerializableExtra(Constants.OWNER) as Owner
        tv_name.text = owner.name
        tv_id_or_age.text = getString(R.string.id_lb) + owner.id.toString()
        tv_phone.text = getString(R.string.phone_lb) + owner.phone

        val recyclerView = findViewById<RecyclerView>(R.id.rv_pets)
        recyclerView.layoutManager = LinearLayoutManager(this)

        ownerDetailViewModel = ViewModelProviders.of(this).get(OwnerDetailViewModel::class.java)

        ownerDetailViewModel.getOwnerPets(owner.id).observe(this, Observer {
            val adapter = PetRVAdapter(this, it as ArrayList<Pet>, this, this)
            recyclerView.adapter = adapter
        })

        fab.setOnClickListener { view ->
            val intent = Intent(this, PetNewActivity::class.java)
            intent.putExtra(Constants.ID_OWNER, owner.id)
            startActivity(intent)
        }
    }

    override fun onItemClick(pet: Pet) {
        val intent = Intent(this, PetDetailActivity::class.java)
        intent.putExtra(Constants.PET, pet)
        startActivity(intent)
    }

    override fun onLongClick(pet: Pet) {
    }
}
