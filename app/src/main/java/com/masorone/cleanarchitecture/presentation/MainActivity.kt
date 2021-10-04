package com.masorone.cleanarchitecture.presentation

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.ViewModelProvider
import com.masorone.cleanarchitecture.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private lateinit var vm: MainViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        vm = ViewModelProvider(this, MainViewModelFactory(this))[MainViewModel::class.java]
        vm.resultSave.observe(this, {
            binding.saveResult.text = it
        })
        vm.firstName.observe(this, {
            binding.textViewFirstName.text = it
        })
        vm.lastName.observe(this, {
            binding.textViewLastName.text = it
        })

        binding.buttonSaveUser.setOnClickListener {
            vm.save(
                binding.editTextFirstName.text.toString(),
                binding.editTextLastName.text.toString()
            )
        }

        binding.buttonGetUser.setOnClickListener {
            vm.load()
        }
    }
}