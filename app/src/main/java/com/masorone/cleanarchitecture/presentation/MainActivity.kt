package com.masorone.cleanarchitecture.presentation

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import com.masorone.cleanarchitecture.R
import com.masorone.cleanarchitecture.domain.models.SaveUserNameParam
import com.masorone.cleanarchitecture.domain.models.UserName
import com.masorone.cleanarchitecture.domain.usecase.GetUserNameUseCase
import com.masorone.cleanarchitecture.domain.usecase.SaveUserNameUseCase

class MainActivity : AppCompatActivity() {

    private val getUserNameUseCase = GetUserNameUseCase()
    private val saveUserNameUseCase = SaveUserNameUseCase()

    @SuppressLint("SetTextI18n")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val dataText = findViewById<TextView>(R.id.textViewData)
        val dataEditText = findViewById<EditText>(R.id.editTextData)
        val getDataButton = findViewById<Button>(R.id.buttonGetData)
        val saveDataButton = findViewById<Button>(R.id.buttonSaveData)

        saveDataButton.setOnClickListener {
            val text = dataEditText.text.toString()
            val params = SaveUserNameParam(name = text)
            val result: Boolean = saveUserNameUseCase.execute(param = params)
            dataText.text = "save result = $result"
        }

        getDataButton.setOnClickListener {
            val userName: UserName = getUserNameUseCase.execute()
            dataText.text = "${userName.firstName} ${userName.lastName}"
        }
    }
}