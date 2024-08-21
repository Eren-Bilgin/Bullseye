package com.yourcompany.bullseye.components

import com.yourcompany.bullseye.R

fun alertTitle(
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
    return title
}