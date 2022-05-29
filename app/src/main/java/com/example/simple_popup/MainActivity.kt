package com.example.simple_popup

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import android.widget.Toast

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val tv = findViewById<TextView>(R.id.tv_title)
        tv.setOnClickListener {
            val list = mutableListOf<SimplePopupValue>().apply {
                add(SimplePopupValue("menu_title_01", R.drawable.ic_baseline_looks_one_24))
                add(SimplePopupValue("menu_title_02", R.drawable.ic_baseline_looks_two_24))
                add(SimplePopupValue("menu_title_03", R.drawable.ic_baseline_looks_3_24))
            }

            SimplePopup(context = applicationContext, popupList = list) {  _, popupValue, position ->
                when (position) {
                    0 -> {
                        Toast.makeText(applicationContext, "Clicked $position ${popupValue.title}", Toast.LENGTH_SHORT).show()
                    }

                    1 -> {
                        Toast.makeText(applicationContext, "Clicked $position ${popupValue.title}", Toast.LENGTH_SHORT).show()
                    }

                    2 -> {
                        Toast.makeText(applicationContext, "Clicked $position ${popupValue.title}", Toast.LENGTH_SHORT).show()
                    }
                }
            }.apply {
                isOutsideTouchable = true
                isTouchable = true
                showAsDropDown(it, 60, 10)
            }

        }
    }
}