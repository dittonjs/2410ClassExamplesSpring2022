package com.usu.anactualkotlinapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModelProvider

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val viewModel: MainViewModel = ViewModelProvider(this).get(MainViewModel::class.java)
        val countTextView: TextView = findViewById(R.id.count);
        viewModel.count = MutableLiveData();
        viewModel.count.observe(this) {
            countTextView.text = "$it"
        }
        val incrementButton: Button = findViewById(R.id.increment)
        incrementButton.setOnClickListener {
            viewModel.increment()
        }
        val decrementButton: Button = findViewById(R.id.decrement);
        decrementButton.setOnClickListener {
            viewModel.decrement()
        }
    }
}