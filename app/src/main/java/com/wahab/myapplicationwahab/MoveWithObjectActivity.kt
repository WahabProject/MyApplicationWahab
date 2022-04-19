package com.wahab.myapplicationwahab

import android.app.Person
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView

class MoveWithObjectActivity : AppCompatActivity() {

    companion object{
        const val EXTRA_DATA = "extra_data"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_move_with_object)

        val tvObject: TextView = findViewById(R.id.tv_object_received)

        val data = intent.getParcelableExtra<Person>(EXTRA_DATA) as Data

        val text = "Name : ${data.name.toString()}, \nEmail : ${data.email}, \nAge : ${data.age}, \nLocation : ${data.city}"
        tvObject.text = text


    }
}