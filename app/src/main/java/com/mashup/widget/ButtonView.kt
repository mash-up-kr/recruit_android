package com.mashup.widget

import android.content.Context
import android.util.AttributeSet
import androidx.annotation.ColorRes
import androidx.core.content.ContextCompat
import com.google.android.material.button.MaterialButton
import com.mashup.R
import com.mashup.extensions.dp

class ButtonView @JvmOverloads constructor(
    context: Context,
    attrs: AttributeSet? = null,
    defStyleAttr: Int = R.attr.materialButtonStyle
) : MaterialButton(context, attrs, defStyleAttr) {

    init {
        initButtonTextStyle()
        initButtonViewLayout()
        setButtonStyle(ButtonStyle.PRIMARY)
    }

    fun setOnButtonClickListener(clickListener: () -> Unit) {
        setOnClickListener {
            clickListener()
        }
    }

    fun setButtonStyle(buttonStyle: ButtonStyle) {
        setBackgroundColor(
            ContextCompat.getColor(context, buttonStyle.backgroundColorRes)
        )
        setTextColor(
            ContextCompat.getColor(context, buttonStyle.textColorRes)
        )
    }

    private fun initButtonViewLayout() {
        cornerRadius = CORNER_RADIUS.dp(context)
        stateListAnimator = null
        insetTop = 0
        insetBottom = 0
        setPadding(
            paddingStart,
            PADDING_VERTICAL.dp(context),
            paddingEnd,
            PADDING_VERTICAL.dp(context)
        )
    }

    private fun initButtonTextStyle() {
        text = DEFAULT_BUTTON_TEXT
        textSize = 16f
        setTextAppearance(R.style.TextAppearance_Mashup_Medium)
    }

    enum class ButtonStyle(@ColorRes val backgroundColorRes: Int, @ColorRes val textColorRes: Int) {
        PRIMARY(backgroundColorRes = R.color.primary, textColorRes = R.color.white),
        DEFAULT(backgroundColorRes = R.color.gray100, textColorRes = R.color.gray600)
    }

    companion object {
        private const val DEFAULT_BUTTON_TEXT = "다음"

        private const val CORNER_RADIUS = 12
        private const val PADDING_VERTICAL = 14
        private const val HEIGHT_BUTTON = 52
    }
}