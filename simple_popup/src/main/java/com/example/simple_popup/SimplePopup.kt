package com.example.simple_popup

import android.app.ActionBar
import android.content.Context
import android.util.TypedValue
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.PopupWindow
import android.widget.TextView
import androidx.core.content.ContextCompat
import com.example.simple_popup.databinding.LayoutSimplePopupBinding

class SimplePopup(
    context: Context,
    popupList: MutableList<SimplePopupValue>,
    menuItemListener: (View?, SimplePopupValue, Int) -> Unit,
) : PopupWindow(context) {

    init {
        val inflater = LayoutInflater.from(context)

        val binding = LayoutSimplePopupBinding.inflate(inflater, null, false)

        // PopupWindow Value Setting
        contentView = binding.root
        width = getDp(context, 250.0f)

        val layoutParam = LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT,
            ActionBar.LayoutParams.WRAP_CONTENT)

        for (i in 0 until popupList.size) {
            val view = inflater.inflate(R.layout.item_simple_popup, null, false)

            val tvMenuTitle = view.findViewById(R.id.tv_menu_title) as TextView
            val ivMenuIcon = view.findViewById(R.id.iv_menu_icon) as ImageView
            val vLine = view.findViewById(R.id.v_line) as View

            tvMenuTitle.text = popupList[i].title
            ivMenuIcon.setImageResource(popupList[i].resId)

            vLine.visibility = if (i < popupList.size - 1) View.VISIBLE else View.INVISIBLE

            view.setOnClickListener {
                menuItemListener.invoke(it, popupList[i], i)
                dismiss()
            }

            binding.llPopup.addView(view, layoutParam)
        }

        val layout = contentView
        layout.measure(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT)
        height = layout.measuredHeight

        setBackgroundDrawable(ContextCompat.getDrawable(context, R.drawable.bg_transparent))
    }

    private fun getDp(context: Context, value: Float): Int {
        val dm = context.resources.displayMetrics
        return TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, value, dm).toInt()
    }

}