package com.edwinacubillos.veterinarioapp.ui.pet_new

import android.os.Bundle
import android.text.TextUtils
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProviders
import com.edwinacubillos.veterinarioapp.R
import com.edwinacubillos.veterinarioapp.model.Pet
import com.edwinacubillos.veterinarioapp.utils.Constants
import com.google.android.material.snackbar.Snackbar
import kotlinx.android.synthetic.main.activity_owner_new.*
import kotlinx.android.synthetic.main.activity_pet_new.fab
import kotlinx.android.synthetic.main.activity_pet_new.toolbar
import kotlinx.android.synthetic.main.content_pet_new.*

class PetNewActivity : AppCompatActivity() {

    private lateinit var petNewViewModel: PetNewViewModel
    private var id_owner: Int? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_pet_new)
        setSupportActionBar(toolbar)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        petNewViewModel = ViewModelProviders.of(this).get(PetNewViewModel::class.java)

        val intent = intent.extras
        if (intent != null)
            id_owner = intent.getInt(Constants.ID_OWNER)

        val adapterKindPet = ArrayAdapter.createFromResource(
            this,
            R.array.kind_pet,
            android.R.layout.simple_spinner_item
        )
        adapterKindPet.setDropDownViewResource(android.R.layout.simple_dropdown_item_1line)
        sp_kind_pet.adapter = adapterKindPet

        val adapterRacesDog = ArrayAdapter.createFromResource(
            this,
            R.array.dog_races,
            android.R.layout.simple_spinner_item
        )
        adapterRacesDog.setDropDownViewResource(android.R.layout.simple_dropdown_item_1line)

        val adapterRacesCat = ArrayAdapter.createFromResource(
            this,
            R.array.cat_races,
            android.R.layout.simple_spinner_item
        )
        adapterRacesCat.setDropDownViewResource(android.R.layout.simple_dropdown_item_1line)

        val adapterRacesBird = ArrayAdapter.createFromResource(
            this,
            R.array.bird_races,
            android.R.layout.simple_spinner_item
        )
        adapterRacesBird.setDropDownViewResource(android.R.layout.simple_dropdown_item_1line)

        sp_race_pet.adapter = adapterRacesDog

        sp_kind_pet.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onNothingSelected(parent: AdapterView<*>?) {
            }

            override fun onItemSelected(
                parent: AdapterView<*>?,
                view: View?,
                position: Int,
                id: Long
            ) {
                when (position) {
                    0 -> sp_race_pet.adapter = adapterRacesDog
                    1 -> sp_race_pet.adapter = adapterRacesCat
                    else -> sp_race_pet.adapter = adapterRacesBird
                }
            }
        }

        fab.setOnClickListener { view ->
            if (TextUtils.isEmpty(et_id.text) || TextUtils.isEmpty(et_name.text) || TextUtils.isEmpty(
                    et_age.text
                )
            ) {
                Snackbar.make(
                    coordinador_layout,
                    getString(R.string.msg_empty_fields),
                    Snackbar.LENGTH_LONG
                )
            } else {
                val pet = Pet(
                    et_id.text.toString().toInt(),
                    id_owner!!,
                    et_name.text.toString(),
                    et_age.text.toString(),
                    sp_kind_pet.selectedItem.toString(),
                    sp_race_pet.selectedItem.toString()
                )
                petNewViewModel.insertPet(pet)
                onBackPressed()
            }
        }
    }
}
