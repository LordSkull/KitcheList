package com.example.kitchenlist

import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class DetailedFoodActivity : AppCompatActivity() {



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_detailed_food)

        val food = intent.getParcelableExtra<Food>("food")
        if (food != null) {

            val imageView : ImageView = findViewById(R.id.detailedFoodImage)
            val textView : TextView = findViewById(R.id.detailedFoodName)
            val description : TextView = findViewById(R.id.listaIngredienti)
            val preparetion : TextView = findViewById(R.id.detailedDescription)

            textView.text = food.name
            imageView.setImageResource(food.image)
            description.text = food.ingredientsDescription
            preparetion.text = food.preparetion
        }


        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }
}