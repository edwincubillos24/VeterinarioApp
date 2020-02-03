package com.edwinacubillos.veterinarioapp.ui.owner_new

import android.os.Bundle
import android.text.TextUtils
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProviders
import com.edwinacubillos.veterinarioapp.R
import com.edwinacubillos.veterinarioapp.model.Owner
import com.google.android.material.snackbar.Snackbar
import kotlinx.android.synthetic.main.activity_owner_new.*
import kotlinx.android.synthetic.main.content_owner_new.*

class OwnerNewActivity : AppCompatActivity() {

    private lateinit var ownerNewViewModel: OwnerNewViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_owner_new)
        setSupportActionBar(toolbar)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        ownerNewViewModel = ViewModelProviders.of(this).get(OwnerNewViewModel::class.java)

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
                val owner = Owner(
                    et_id.text.toString().toInt(),
                    et_name.text.toString(),
                    et_age.text.toString()
                )
                ownerNewViewModel.insertOwner(owner)
                onBackPressed()
            }
        }
    }
}
