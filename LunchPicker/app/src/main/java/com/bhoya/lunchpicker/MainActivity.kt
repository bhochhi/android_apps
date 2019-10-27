package com.bhoya.lunchpicker

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import kotlinx.android.synthetic.main.activity_main.*
import kotlin.random.Random

class MainActivity : AppCompatActivity() {
    private val foodList = arrayListOf("Pizza","McDonnell's","Taco","Chinese","Hibachi")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        decideBtn.setOnClickListener {
            val random = Random.nextInt(foodList.size)
            println("select random: $random")
            val selectedFood = foodList[random]
            selectedFoodText.text = selectedFood
        }


        addBtn.setOnClickListener{
            val addFood = addFoodTxt.text
            if(!addFood.isNullOrEmpty()){
                foodList.add(addFood.toString())
                addFoodTxt.text.clear()
            }
            println(foodList)
        }
    }
}
