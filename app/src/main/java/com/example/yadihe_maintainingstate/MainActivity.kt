package com.example.yadihe_maintainingstate

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.ImageView
import androidx.activity.ComponentActivity
import androidx.activity.viewModels

class MainActivity : ComponentActivity() {

    private val vm: StateVM by viewModels()
    private lateinit var imageView: ImageView
    private lateinit var editText: EditText
    private lateinit var button: Button


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.layout)
        imageView = findViewById(R.id.imageView)
        editText = findViewById(R.id.editText)
        button = findViewById(R.id.button)
        editText.setText(vm.getText())
        imageView.setImageResource(vm.getImage())

        button.setOnClickListener {
            vm.randomImg()
            imageView.setImageResource(vm.getImage())
        }

    }

    override fun onDestroy() {
        super.onDestroy()
        vm.setText(editText.text.toString())
    }
}
