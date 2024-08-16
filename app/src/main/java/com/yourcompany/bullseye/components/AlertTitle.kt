package com.yourcompany.bullseye.components

import androidx.compose.material3.Text
import com.yourcompany.bullseye.R
import kotlin.math.abs

fun AlertTitle(
    targetValue: Int,
    sliderValue: Int,
    difference: Int
): Int {
    val title: Int = if (difference == 0) {
        R.string.alert_title_1
    } else if (difference < 5) {
        R.string.alert_title_2
    } else if (difference <= 10) {
        R.string.alert_title_3
    } else {
        R.string.alert_title_4
    }

    /* val title: Int = when {
         difference == 0 -> {
             R.string.alert_title_1
         }
         difference < 5 -> {
             R.string.alert_title_2
         }
         difference <= 10 -> {
             R.string.alert_title_3
         }
         else -> {
             R.string.alert_title_4
         }
     }*/


    return title
}