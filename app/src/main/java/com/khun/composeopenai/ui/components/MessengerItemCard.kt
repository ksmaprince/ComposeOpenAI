package com.khun.composeopenai.ui.components

import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Composable
fun MessengerItemCard(
    modifier: Modifier = Modifier,
    message: String = ""
) {
    Surface(
        modifier = modifier,
        color = MaterialTheme.colorScheme.primary,
        shape = RoundedCornerShape(topStart = 25.dp, bottomEnd = 25.dp, bottomStart = 25.dp)
    ) {
        Text(
            modifier = Modifier
                .wrapContentSize()
                .padding(horizontal = 24.dp, vertical = 18.dp),
            text = message,
            textAlign = TextAlign.Center,
            style = MaterialTheme.typography.labelLarge.copy(color = Color.White)
        )
    }
}

@Preview
@Composable
fun MessengerItemPreview() {
    MessengerItemCard()
}