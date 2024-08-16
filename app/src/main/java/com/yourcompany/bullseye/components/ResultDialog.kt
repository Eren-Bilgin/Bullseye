package com.yourcompany.bullseye.components

import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.res.stringResource
import com.yourcompany.bullseye.R
import kotlin.random.Random

@Composable
fun ResultDialog(
    sliderValue: Int,
    targetValue: Int,
    difference: Int,
    onConfirmButtonClick_Random: (Int) -> Unit,
    points: Int,
    dialogTitle: Int,
    ) {


    AlertDialog(onDismissRequest = {
        onConfirmButtonClick_Random(Random.nextInt(1, 100))
    },
        confirmButton = {
            TextButton(
                onClick = {
                    onConfirmButtonClick_Random(Random.nextInt(1, 100))
                }
            ) {
                Text(stringResource(R.string.result_dialog_button_text))
            }
        },
        title = { Text(stringResource(id = dialogTitle)) },


        text = {
            Text(
                stringResource(
                    R.string.result_dialog_message, sliderValue,
                    difference,
                    points
                )
            )
        }

    )
}
