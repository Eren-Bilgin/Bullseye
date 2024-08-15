package com.yourcompany.bullseye.components

import android.graphics.drawable.Icon
import android.util.Log
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Info
import androidx.compose.material.icons.filled.Refresh
import androidx.compose.material3.Button
import androidx.compose.material3.FilledIconButton
import androidx.compose.material3.FilledTonalButton
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.yourcompany.bullseye.R
import com.yourcompany.bullseye.screens.AboutScreen

@Composable
fun GameDetail(
    modifier: Modifier = Modifier,
    totalScore: Int = 0,
    round: Int = 1,
    onConfirmButtonClickDetailStart: () -> Unit,
    onNavigateToAbout: () -> Unit

) {

    Row(
        modifier = modifier.fillMaxWidth(),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.Absolute.SpaceBetween
    ) {
        FilledIconButton(
            onClick = { onConfirmButtonClickDetailStart() },
            colors = IconButtonDefaults.filledIconButtonColors(
                contentColor = MaterialTheme.colorScheme.tertiary
            ),
            modifier = Modifier.size(50.dp)
        ) {
            Icon(
                Icons.Filled.Refresh,
                contentDescription = stringResource(id = R.string.restart_btn_desc)
            )
        }

        GameInfo(label = stringResource(id = R.string.score_label), value = totalScore)

        GameInfo(label = stringResource(id = R.string.current_round_label), value = round)

        FilledIconButton(
            onClick = { onNavigateToAbout() },

            colors = IconButtonDefaults.filledIconButtonColors(
                contentColor = MaterialTheme.colorScheme.tertiary
            ),
            modifier = Modifier.size(50.dp)
        )
        {
            Icon(
                Icons.Filled.Info,
                contentDescription = stringResource(id = R.string.about_btn_desc)

            )

        }
    }
}

@Composable
fun GameInfo(label: String, value: Int) {
    Column(

        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(label)
        Text(value.toString(), style = MaterialTheme.typography.labelLarge.copy(fontSize = 20.sp))
    }
}

@Preview(showBackground = true)
@Composable
fun GameDetailPreview() {
    GameDetail(onConfirmButtonClickDetailStart = {}, onNavigateToAbout = {})
}