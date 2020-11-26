/*
package com.example.cifreiapk.utils

import android.graphics.Typeface
import android.text.SpannableString
import android.text.style.StyleSpan
import java.lang.reflect.Array.set

class SpannableUtils {

    fun destacarTextoComNegrito(
        textoCompleto: String,
        textoDestaque: String,
        textView: String
    ) {

        val start = textoCompleto.indexOf(textoDestaque)
        val end = start + textoDestaque.length

        val spannableText = SpannableString(textoCompleto)
        spannableText.setSpan(StyleSpan(Typeface.BOLD), start, end, 0)

        textView?.set(spannableText)
    }
}
*/
