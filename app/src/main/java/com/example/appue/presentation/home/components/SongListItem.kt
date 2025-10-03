package com.kcarbzz.appue.presentation.home.components

import androidx.compose.foundation.layout.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.MoreVert
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp

// Modelo de Datos
data class Song(
    val id: Int,
    val title: String,
    val artist: String
)

@Composable
fun SongListItem(song: Song, modifier: Modifier = Modifier) {
    // Usamos el color blanco y variantes para simular el tema oscuro de Spotify
    val textColor = Color.White
    val secondaryTextColor = Color.LightGray

    Row(
        modifier = modifier
            .fillMaxWidth()
            .padding(vertical = 8.dp, horizontal = 16.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        // 1. Placeholder de Posición/Número
        Text(
            text = song.id.toString(),
            style = MaterialTheme.typography.bodyLarge,
            color = secondaryTextColor.copy(alpha = 0.7f),
            modifier = Modifier.width(30.dp)
        )

        // 2. Título y Artista
        Column(
            modifier = Modifier
                .weight(1f)
                .padding(start = 12.dp)
        ) {
            Text(
                text = song.title,
                style = MaterialTheme.typography.bodyLarge,
                fontWeight = FontWeight.SemiBold,
                color = textColor
            )
            Spacer(modifier = Modifier.height(2.dp))
            Text(
                text = song.artist,
                style = MaterialTheme.typography.bodyMedium,
                color = secondaryTextColor
            )
        }

        // 3. Botón de Opciones
        IconButton(onClick = { /* Acción: Abrir menú de canción */ }) {
            Icon(
                imageVector = Icons.Default.MoreVert,
                contentDescription = "Opciones",
                tint = secondaryTextColor
            )
        }
    }
}
