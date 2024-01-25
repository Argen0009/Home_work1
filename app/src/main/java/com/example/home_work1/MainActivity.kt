package com.example.home_work1

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import com.example.home_work1.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private val binding: ActivityMainBinding by lazy {
        ActivityMainBinding.inflate(layoutInflater)
    }

    private val viewModel: MainViewModel by lazy {
        ViewModelProvider(this)[MainViewModel::class.java]
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        viewModel.counterLv.observe(this) { result ->
            binding.tvResult.text = result.toString()
        }
        with(binding) {
            btnMin.setOnClickListener {
                viewModel.dec()
            }
            btnPluss.setOnClickListener {
                viewModel.inc()
            }
        }
    }
}