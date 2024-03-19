package com.example.yadihe_maintainingstate

import android.app.Application
import android.content.Context
import android.content.SharedPreferences
import androidx.lifecycle.AndroidViewModel
import kotlin.random.Random

class StateVM(application: Application) : AndroidViewModel(application) {

    private val sharedPreferences: SharedPreferences = application.getSharedPreferences("MyPrefs", Context.MODE_PRIVATE)
    private val TEXT_KEY = "text"
    private val IMAGE_KEY = "image"
    private var text:String=""
    private var image:Int=0
    private val imageResources = arrayOf(
        R.drawable.p1,
        R.drawable.p2,
        R.drawable.p3,
        R.drawable.p4,
        R.drawable.p5,
        R.drawable.p6,

        )

    init {
        text = sharedPreferences.getString(TEXT_KEY, "") ?: ""
        image = sharedPreferences.getInt(IMAGE_KEY, 0)
    }
    fun setText(t: String) {
        text = t
        sharedPreferences.edit().putString(TEXT_KEY, t).apply()
    }

    fun getText(): String {
        return text
    }

    fun setImage(i: Int) {
        image = i
        sharedPreferences.edit().putInt(IMAGE_KEY, i).apply()
    }

    fun getImage(): Int {
        return imageResources[image]
    }

    fun randomImg() {
        image = Random.nextInt(imageResources.size)
        sharedPreferences.edit().putInt(IMAGE_KEY, image).apply()
    }
}
