package com.yourcompany.bullseye.components

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.yourcompany.bullseye.R

@Composable
fun GamePrompt(
    modifier: Modifier = Modifier,
    targetValue: Int,
) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = modifier
    ) {
        Text(
            stringResource(R.string.instruction_text),
            style = MaterialTheme.typography.titleMedium.copy(
                letterSpacing = 1.sp,
                fontWeight = FontWeight.Bold
            )
        )
        Text(
            stringResource(R.string.target_value_text, targetValue),
            modifier = modifier.padding(8.dp),
            style = MaterialTheme.typography.displayMedium.copy(fontWeight = FontWeight.Bold)
        )
    }

}