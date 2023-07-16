package dev.giridharaspk.currencyconvertor.ui

import android.content.Context
import android.graphics.Bitmap
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import dev.giridharaspk.currencyconvertor.data.repo.CurrencyRepository
import dev.giridharaspk.currencyconvertor.databinding.ActivityMainBinding
import dev.giridharaspk.currencyconvertor.ui.viewmodel.CurrencyConversionViewModel
import dev.giridharaspk.currencyconvertor.ui.viewmodel.ViewModelProviderFactory


class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    val TAG = "MainActivity"
    private lateinit var viewModel: CurrencyConversionViewModel
    private val context: Context = this@MainActivity
    private var rvAdapter: ConvertedCurrenciesAdapter = ConvertedCurrenciesAdapter(ArrayList())


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        initView()
        setupViewModel()
        setAdapters()
        setListeners()
        setObservers()
    }

    private fun setListeners() {
        binding.etBaseCurrencyValue.addOnTextChangedListener
    }

    private fun initView() {
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }

    private fun setupViewModel() {
        viewModel = ViewModelProvider(
            this,
            ViewModelProviderFactory(
                CurrencyConversionViewModel(
                    CurrencyRepository,
                )
            )
        ).get(CurrencyConversionViewModel::class.java)

    }

    private fun setAdapters() {
        rvAdapter = ConvertedCurrenciesAdapter(itemList)
        binding.rvConversions.adapter = rvAdapter

        val numberOfColumns = 3
        binding.rvConversions.layoutManager = GridLayoutManager(this, numberOfColumns)
    }
}