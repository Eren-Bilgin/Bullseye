package com.yourcompany.bullseye.components


fun pointsForCurrentRound(
    difference: Int
): Int {
    val maxPoint = 100
    val totalValue = (maxPoint - difference)
    var bonus = 0
    if (difference == 0) {
        bonus = 100
    } else if (difference == 1) {
        bonus = 50
    }
    return (totalValue + bonus)
}


