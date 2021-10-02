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

        vm = ViewModelProvider(this)[MainViewModel::class.java]

        val dataText = findViewById<TextView>(R.id.textViewData)
        val dataEditText = findViewById<EditText>(R.id.editTextData)
        val getDataButton = findViewById<Button>(R.id.buttonGetData)
        val saveDataButton = findViewById<Button>(R.id.buttonSaveData)

        saveDataButton.setOnClickListener {
            val text = dataEditText.text.toString()
            dataText.text = vm.save(text)
        }

        getDataButton.setOnClickListener {
            dataText.text = vm.load()
        }
    }
}