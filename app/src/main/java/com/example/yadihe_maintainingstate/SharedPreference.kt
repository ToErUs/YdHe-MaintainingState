package com.example.yadihe_maintainingstate

import android.app.Application
import android.content.Context
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import kotlin.random.Random

class SharedPreference(application: Application) : AndroidViewModel(application) {

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
    fun setText(t:String){
        text=t
    }
    fun getText():String{
        return text
    }
    fun setImage(i:Int){
        image=i
    }
    fun getImage():Int{
        return imageResources[image]
    }
    fun randomImg(){
        image = Random.nextInt(imageResources.size)
    }
}
