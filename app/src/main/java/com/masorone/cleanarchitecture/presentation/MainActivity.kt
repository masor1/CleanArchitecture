package com.masorone.cleanarchitecture.presentation

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.lifecycle.ViewModelProvider
import com.masorone.cleanarchitecture.R

class MainActivity : AppCompatActivity() {

    private lateinit var vm: MainViewModel


    @SuppressLint("SetTextI18n")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        Log.e("AAA", "Activity created")

        vm = ViewModelProvider(this, MainViewModelFactory(this))[MainViewModel::class.java]

        val dataText = findViewById<TextView>(R.id.textViewData)
        val dataEditText = findViewById<EditText>(R.id.editTextData)
        val getDataButton = findViewById<Button>(R.id.buttonGetData)
        val saveDataButton = findViewById<Button>(R.id.buttonSaveData)

        vm.resultLive.observe(this, {
            dataText.text = it
        })

        saveDataButton.setOnClickListener {
            vm.save(dataEditText.text.toString())
        }

        getDataButton.setOnClickListener {
            vm.load()
        }
    }

    override fun onStop() {
        Log.e("AAA", "Activity stop")
        super.onStop()
    }

    override fun onStart() {
        Log.e("AAA", "Activity start")
        super.onStart()
    }

    override fun onDestroy() {
        Log.e("AAA", "Activity destroy")
        super.onDestroy()
    }

    override fun onResume() {
        Log.e("AAA", "Activity resume")
        super.onResume()
    }

    override fun onRestart() {
        Log.e("AAA", "Activity restart")
        super.onRestart()
    }
}