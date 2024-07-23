package com.example.fruitselector

import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.Spinner
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val fruitSpinner = findViewById<Spinner>(R.id.fruitSpinner)
        val showFruitButton = findViewById<Button>(R.id.showFruitButton)
        val selectedFruitTextView = findViewById<TextView>(R.id.selectedFruitTextView)


        ArrayAdapter.createFromResource(
            this,
            R.array.fruits,
            android.R.layout.simple_spinner_item
        ).also { adapter ->

            adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)

            fruitSpinner.adapter = adapter
        }

        var selectedFruit = ""

        fruitSpinner.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onItemSelected(parent: AdapterView<*>, view: View?, position: Int, id: Long) {
                selectedFruit = parent.getItemAtPosition(position).toString()
            }

            override fun onNothingSelected(parent: AdapterView<*>) {

            }
        }

        showFruitButton.setOnClickListener {
            selectedFruitTextView.text = "Selected Fruit: $selectedFruit"
        }
    }
}
