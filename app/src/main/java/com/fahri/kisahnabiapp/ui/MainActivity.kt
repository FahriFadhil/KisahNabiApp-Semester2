package com.fahri.kisahnabiapp.ui

import android.content.Intent
import android.nfc.NfcAdapter.EXTRA_DATA
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.GridLayoutManager
import com.fahri.kisahnabiapp.R
import com.fahri.kisahnabiapp.data.response.NabiResponse
import com.fahri.kisahnabiapp.data.utils.OnItemClickCallback
import com.fahri.kisahnabiapp.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private var _binding : ActivityMainBinding? = null
    private val binding get() = _binding as ActivityMainBinding

    private var _viewModel : MainViewModel? = null
    private val viewModel get() = _viewModel as MainViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        _binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        _viewModel = ViewModelProvider(this).get(MainViewModel::class.java)
        viewModel.getData()
        viewModel.kisahResponse.observe(this) { showData(it) }
        viewModel.isLoading.observe(this) { showLoading(it) }
        viewModel.isError.observe(this) { showError(it) }
    }

    private fun showData(list: List<NabiResponse>?) {
        binding.recyclerMain.apply {
            val mAdapter = NabiAdapter()
            mAdapter.setData(list)
            layoutManager = GridLayoutManager(this@MainActivity, 2)
            adapter = mAdapter
            mAdapter.setOnItemClickCallback(object : OnItemClickCallback {
                override fun onItemClicked(item: NabiResponse) {
                    startActivity(Intent( applicationContext, DetailActivity::class.java).putExtra(DetailActivity.EXTRA_DATA, item))
                }
            })
        }
    }

    private fun showLoading(load: Boolean?) {
        if (load == true) {
            binding.progressMain.visibility = View.VISIBLE
            binding.recyclerMain.visibility = View.INVISIBLE
        } else {
            binding.progressMain.visibility = View.INVISIBLE
            binding.recyclerMain.visibility = View.VISIBLE
        }
    }

    private fun showError(err: Throwable?) {
        Log.e("MainActivity", "showError: $err", )
    }



}