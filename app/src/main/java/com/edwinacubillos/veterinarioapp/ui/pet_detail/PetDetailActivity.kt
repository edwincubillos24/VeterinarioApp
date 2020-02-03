package com.edwinacubillos.veterinarioapp.ui.pet_detail

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.edwinacubillos.veterinarioapp.R
import com.edwinacubillos.veterinarioapp.model.Pet
import com.edwinacubillos.veterinarioapp.model.Vaccine
import com.edwinacubillos.veterinarioapp.ui.VaccineActivity.VaccineActivity
import com.edwinacubillos.veterinarioapp.ui.VaccineActivity.VaccineRVAdapter
import com.edwinacubillos.veterinarioapp.utils.Constants
import kotlinx.android.synthetic.main.activity_pet_detail.*
import kotlinx.android.synthetic.main.content_pet_detail.*

class PetDetailActivity : AppCompatActivity() {

    private lateinit var petDetailViewModel: PetDetailViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_pet_detail)
        setSupportActionBar(toolbar)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        val pet = intent?.getSerializableExtra(Constants.PET) as Pet
        tv_name.text = pet.name
        tv_id_or_age.text = getString(R.string.age_lb) + pet.age
        tv_race.text = getString(R.string.race_lb) + pet.race
        tv_id_owner.text = getString(R.string.id_owner_lb) + pet.id_owner.toString()
        if (pet.kind == Constants.DOG) iv_picture.setImageResource(R.drawable.dog)
        else if (pet.kind == Constants.CAT) iv_picture.setImageResource(R.drawable.cat)
        else iv_picture.setImageResource(R.drawable.bird)

        val recyclerView = findViewById<RecyclerView>(R.id.rv_vaccine)
        recyclerView.layoutManager = LinearLayoutManager(this)

        petDetailViewModel = ViewModelProviders.of(this).get(PetDetailViewModel::class.java)

        petDetailViewModel.getPetVaccines(pet.id).observe(this, Observer {
            val adapter = VaccineRVAdapter(this, it as ArrayList<Vaccine>)
            recyclerView.adapter = adapter
        })

        fab.setOnClickListener { view ->
            val intent = Intent(this, VaccineActivity::class.java)
            intent.putExtra(Constants.ID_PET, pet.id)
            startActivity(intent)
        }
    }
}
