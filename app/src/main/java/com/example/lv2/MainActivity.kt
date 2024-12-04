package com.example.lv2

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.data.RepositoryImpl
import com.example.domain.Repository
import com.example.lv2.databinding.ActivityMainBinding
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private val repository: Repository = RepositoryImpl()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        CoroutineScope(Dispatchers.IO).launch {
            val data = repository.getProducts()
            val adapter = ProductAdapter(data)

            CoroutineScope(Dispatchers.Main).launch {
                binding.recyclerViewProducts.adapter = adapter
                binding.recyclerViewProducts.layoutManager = LinearLayoutManager(this@MainActivity)

            }


        }

    }
}