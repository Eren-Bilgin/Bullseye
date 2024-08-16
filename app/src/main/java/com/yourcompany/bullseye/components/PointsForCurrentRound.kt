package com.yourcompany.bullseye.components


fun PointsForCurrentRound(
    targetValue: Int,
    sliderValue: Int,
    difference: Int
): Int {
    val maxPoint = 100
    var totalValue: Int
    totalValue = (maxPoint - difference)
    var bonus: Int = 0
    if (difference == 0) {
        bonus = 100
    } else if (difference == 1) {
        bonus = 50
    }


    return (totalValue + bonus)


}


