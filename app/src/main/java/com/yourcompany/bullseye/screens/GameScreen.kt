package com.yourcompany.bullseye.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.blur
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Devices
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.yourcompany.bullseye.R
import com.yourcompany.bullseye.components.GameDetail
import com.yourcompany.bullseye.components.GamePrompt
import com.yourcompany.bullseye.components.ResultDialog
import com.yourcompany.bullseye.components.TargerSlider
import com.yourcompany.bullseye.components.alertTitle
import com.yourcompany.bullseye.components.pointsForCurrentRound
import com.yourcompany.bullseye.ui.theme.BullseyeTheme
import kotlin.math.abs
import kotlin.random.Random

@Composable
fun GameScreen(
    onNavigateToAbout: () -> Unit
) {
    var alertIsVisible by rememberSaveable { mutableStateOf(false) }
    var sliderValue by rememberSaveable { mutableStateOf(0.5f) }
    var targetValue by rememberSaveable { mutableStateOf(Random.nextInt(1, 100)) }
    val sliderToInt = (sliderValue * 100).toInt()
    var totalScore by rememberSaveable { mutableStateOf(0) }
    var currentRound = rememberSaveable { mutableStateOf(1) }
    var difference = abs(targetValue - sliderToInt)
    Box {
        Image(
            modifier = Modifier
                .fillMaxSize()
                .blur(22.dp),
            painter = painterResource(id = R.drawable.background),
            contentScale = ContentScale.FillWidth, // New Code
            contentDescription = stringResource(R.string.background_image)
        )
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center,
            modifier = Modifier
                .fillMaxSize()
                .padding(16.dp)
        ) {
            Spacer(modifier = Modifier.weight(.5f))
            Column(
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.SpaceEvenly,
                modifier = Modifier.weight(9f)
            ) {
                GamePrompt(
                    targetValue = targetValue
                )
                TargerSlider(value = sliderValue, onValueChange = { value -> sliderValue = value })
                Button(
                    onClick = {
                        alertIsVisible = true
                        totalScore += pointsForCurrentRound(
                            difference = difference
                        )
                    }, shape = MaterialTheme.shapes.medium, contentPadding = PaddingValues(16.dp)
                ) {
                    Text(text = stringResource(R.string.hit_me_button_text))
                }
                GameDetail(
                    totalScore = totalScore,
                    round = currentRound.value,
                    modifier = Modifier.fillMaxSize(),
                    onConfirmButtonClickDetailStart = { currentRound.value = 1; totalScore = 0 },
                    onNavigateToAbout = onNavigateToAbout
                )
            }
            val dialogTitle = alertTitle(
                difference = difference
            )
            Spacer(modifier = Modifier.weight(.5f))
            if (alertIsVisible) {
                ResultDialog(
                    sliderValue = sliderToInt,
                    dialogTitle = dialogTitle,
                    difference = difference,
                    onConfirmButtonClickRandom = { number ->
                        targetValue = number
                        currentRound.value += 1
                        alertIsVisible = false
                    },
                    points = pointsForCurrentRound(
                        difference = difference
                    )
                )
            }
        }
    }
}

@Preview(showBackground = true, device = Devices.AUTOMOTIVE_1024p, widthDp = 864, heightDp = 432)
@Composable
fun GameScreenPreview() {
    BullseyeTheme {
        GameScreen(onNavigateToAbout = {})
    }
}