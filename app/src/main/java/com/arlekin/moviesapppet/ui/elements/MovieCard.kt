package com.arlekin.moviesapppet.ui.elements

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Card
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun MovieCard(
    title: String,
    description: String,
    onClick: () -> Unit,
    modifier: Modifier = Modifier,
    ) {
    Row (
        modifier = modifier
            .fillMaxWidth()
            .clickable(enabled = true, onClick = {onClick()})
            .padding(8.dp),
        verticalAlignment = Alignment.CenterVertically
    ){
        Column (modifier = modifier.weight(1f)){
            Text(title)
            Spacer(modifier = Modifier.height(4.dp))
            Text(description)
        }
    }
}

