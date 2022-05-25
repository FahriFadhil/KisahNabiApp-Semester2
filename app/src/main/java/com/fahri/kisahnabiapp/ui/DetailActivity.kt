package com.fahri.kisahnabiapp.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.bumptech.glide.Glide
import com.fahri.kisahnabiapp.R
import com.fahri.kisahnabiapp.data.response.NabiResponse
import com.fahri.kisahnabiapp.databinding.ActivityDetailBinding
import com.fahri.kisahnabiapp.databinding.ActivityMainBinding

class DetailActivity : AppCompatActivity() {

    private var _binding : ActivityDetailBinding? = null
    private val binding get() = _binding as ActivityDetailBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        _binding = ActivityDetailBinding.inflate(layoutInflater)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        setContentView(binding.root)

        val data = intent.getParcelableExtra<NabiResponse>(EXTRA_DATA)
        binding.apply {
            detailNama.text = data?.name
            detailDesk.text = data?.description
            detailTahun.text = data?.thnKelahiran
            detailTempat.text = data?.tempat
            detailUsia.text = data?.usia
            Glide.with(applicationContext).load(data?.img).into(detailImage)
        }
    }

    companion object {
        const val EXTRA_DATA = "Data"
    }

    override fun onSupportNavigateUp(): Boolean {
        onBackPressed()
        return super.onSupportNavigateUp()
    }
}