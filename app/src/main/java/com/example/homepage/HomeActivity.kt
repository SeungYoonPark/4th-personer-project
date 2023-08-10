package com.example.homepage

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.core.content.res.ResourcesCompat

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)

        val tv_id = findViewById<TextView>(R.id.tv_id)
        if (intent.hasExtra("id")) {
            tv_id.text = "아이디 : "+ intent.getStringExtra("id")
        }

        val btn_close = findViewById<ConstraintLayout>(R.id.btn_close)
        btn_close.setOnClickListener{finish()
        }

        val iv_logo = findViewById<ImageView>(R.id.iv_home_logo)

        val id = when ((1 .. 6).random()) {

            1 -> R.drawable.ca1
            2 -> R.drawable.ca2
            3 -> R.drawable.ca3
            4 -> R.drawable.ca4
            5 -> R.drawable.ca5
            else -> R.drawable.ca1

        }

        iv_logo.setImageDrawable(ResourcesCompat.getDrawable(resources, id, null))
    }
}