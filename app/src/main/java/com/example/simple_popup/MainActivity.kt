package com.example.simple_popup

import android.graphics.Color
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
                add(SimplePopupValue("menu_title_01", R.mipmap.ic_launcher))
                add(SimplePopupValue("menu_title_02", R.mipmap.ic_launcher))
                add(SimplePopupValue("menu_title_03", R.mipmap.ic_launcher))
            }

            val popup = SimplePopup(
                context = applicationContext,
                popupList = list,
                menuTitleColor = Color.RED,
                menuVLineColor = Color.YELLOW
            ) { _, popupValue, position ->
                when (position) {
                    0 -> {
                        Toast.makeText(
                            applicationContext,
                            "Clicked $position ${popupValue.title}",
                            Toast.LENGTH_SHORT
                        ).show()
                    }

                    1 -> {
                        Toast.makeText(
                            applicationContext,
                            "Clicked $position ${popupValue.title}",
                            Toast.LENGTH_SHORT
                        ).show()
                    }

                    2 -> {
                        Toast.makeText(
                            applicationContext,
                            "Clicked $position ${popupValue.title}",
                            Toast.LENGTH_SHORT
                        ).show()
                    }
                }
            }.apply {
                isOutsideTouchable = true
                isTouchable = true
            }

            popup.setSimplePopupBackGround(Color.BLUE)
            popup.showAsDropDown(it, 60, 10)

        }
    }
}