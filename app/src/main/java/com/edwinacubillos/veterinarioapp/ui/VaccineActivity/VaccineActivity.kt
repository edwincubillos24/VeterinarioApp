package com.edwinacubillos.veterinarioapp.ui.VaccineActivity

import android.app.DatePickerDialog
import android.os.Bundle
import android.text.TextUtils
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.DatePicker
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.isVisible
import androidx.lifecycle.ViewModelProviders
import com.edwinacubillos.veterinarioapp.R
import com.edwinacubillos.veterinarioapp.model.Vaccine
import com.edwinacubillos.veterinarioapp.utils.Constants
import com.google.android.material.snackbar.Snackbar
import kotlinx.android.synthetic.main.activity_owner_new.*
import kotlinx.android.synthetic.main.activity_vaccine.fab
import kotlinx.android.synthetic.main.activity_vaccine.toolbar
import kotlinx.android.synthetic.main.content_vaccine.*
import java.sql.Types.NULL
import java.text.SimpleDateFormat
import java.util.*

class VaccineActivity : AppCompatActivity() {

    private lateinit var vaccineViewModel: VaccineViewModel

    private lateinit var date: String
    private var cal = Calendar.getInstance()
    private var id_pet: Int? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_vaccine)
        setSupportActionBar(toolbar)

        vaccineViewModel = ViewModelProviders.of(this).get(VaccineViewModel::class.java)

        val intent = intent.extras
        if (intent != null)
            id_pet = intent.getInt(Constants.ID_PET)

        val adapterVaccine = ArrayAdapter.createFromResource(
            this,
            R.array.vaccine,
            android.R.layout.simple_spinner_item
        )
        adapterVaccine.setDropDownViewResource(android.R.layout.simple_dropdown_item_1line)
        sp_vaccine.adapter = adapterVaccine

        sp_vaccine.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onNothingSelected(parent: AdapterView<*>?) {
            }

            override fun onItemSelected(
                parent: AdapterView<*>?,
                view: View?,
                position: Int,
                id: Long
            ) {
                if (position == Constants.THREE) {
                    et_new_vaccine.visibility = View.VISIBLE
                    til_new_vaccine_lb.visibility = View.VISIBLE
                } else {
                    et_new_vaccine.visibility = View.INVISIBLE
                    til_new_vaccine_lb.visibility = View.INVISIBLE
                }
            }
        }

        val dateSetListener = object : DatePickerDialog.OnDateSetListener {
            override fun onDateSet(view: DatePicker?, year: Int, month: Int, dayOfMonth: Int) {
                cal.set(Calendar.YEAR, year)
                cal.set(Calendar.MONTH, month)
                cal.set(Calendar.DAY_OF_MONTH, dayOfMonth)

                val format = Constants.DATE_FORMAT
                val sdf = SimpleDateFormat(format, Locale.US)
                date = sdf.format(cal.time).toString()
                et_date.setText(date)
            }
        }

        et_date.setOnClickListener {
            DatePickerDialog(
                this, dateSetListener,
                cal.get(Calendar.YEAR),
                cal.get(Calendar.MONTH),
                cal.get(Calendar.DAY_OF_MONTH)
            ).show()
        }

        fab.setOnClickListener { view ->
            if (TextUtils.isEmpty(et_date.text) || TextUtils.isEmpty(et_dosis.text)) {
                Snackbar.make(
                    coordinador_layout,
                    getString(R.string.msg_empty_fields),
                    Snackbar.LENGTH_LONG
                )
            } else {
                var name: String
                if (et_new_vaccine.isVisible) name = et_new_vaccine.text.toString()
                else name = sp_vaccine.selectedItem.toString()
                val vaccine = Vaccine(NULL, id_pet!!, name, date, et_dosis.text.toString())
                vaccineViewModel.saveVaccine(vaccine)
                onBackPressed()
            }
        }
    }
}
