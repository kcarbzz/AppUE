package com.kcarbzz.appue.presentation.home

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.PlayArrow
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.kcarbzz.appue.presentation.home.components.Song
import com.kcarbzz.appue.presentation.home.components.SongListItem

// Datos Simulados (Mock Data)
val mockSongs = List(15) { index -> 
    Song(index + 1, "Song Title ${index + 1}", "Artist Name ${index + 1}")
}

@Composable
fun PlaylistScreen(modifier: Modifier = Modifier) {
    val spotifyDark = Color(0xFF191414) 
    val spotifyGreen = Color(0xFF1DB954)

    Scaffold(
        bottomBar = {
            BottomAppBar(containerColor = Color.Black) {
                Text(
                    "Barra Inferior",
                    color = Color.White,
                    modifier = Modifier.padding(16.dp).weight(1f)
                )
            }
        }
    ) { paddingValues ->
        
        LazyColumn(
            modifier = modifier
                .fillMaxSize()
                .background(spotifyDark), 
            contentPadding = paddingValues
        ) {
            
            // 1. Encabezado de la Playlist
            item {
                PlaylistHeader()
            }

            // 2. Botón de Play Flotante
            item {
                Box(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(horizontal = 16.dp, vertical = 24.dp),
                    contentAlignment = Alignment.CenterEnd 
                ) {
                    FloatingActionButton(
                        onClick = { /* Acción: Reproducir la lista */ },
                        containerColor = spotifyGreen, 
                        shape = CircleShape,
                        modifier = Modifier.size(56.dp)
                    ) {
                        Icon(
                            Icons.Filled.PlayArrow, 
                            contentDescription = "Reproducir", 
                            tint = Color.Black,
                            modifier = Modifier.size(32.dp)
                        )
                    }
                }
            }

            // 3. La Lista de Canciones
            items(mockSongs) { song ->
                SongListItem(song = song)
                Divider(
                    color = Color.DarkGray.copy(alpha = 0.3f), 
                    thickness = 0.5.dp, 
                    modifier = Modifier.padding(start = 58.dp, end = 16.dp)
                )
            }
            
            item {
                Spacer(modifier = Modifier.height(64.dp))
            }
        }
    }
}

// Composable Auxiliar para el Encabezado
@Composable
private fun PlaylistHeader() {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(top = 40.dp, bottom = 16.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        // Imagen Grande de Portada (Placeholder)
        Surface(
            modifier = Modifier.size(200.dp),
            color = Color.Gray.copy(alpha = 0.7f), 
            shape = MaterialTheme.shapes.medium
        ) {
            Text(
                text = "COVER",
                style = MaterialTheme.typography.headlineSmall,
                color = Color.White.copy(alpha = 0.9f),
                modifier = Modifier.wrapContentSize(Alignment.Center)
            )
        }
        
        Spacer(Modifier.height(24.dp))
        
        Text(
            text = "Viva Latino",
            style = MaterialTheme.typography.headlineLarge,
            fontWeight = FontWeight.ExtraBold,
            color = Color.White,
            modifier = Modifier.padding(horizontal = 16.dp)
        )
        
        Spacer(Modifier.height(8.dp))
        
        Text(
            text = "Hoy: Natanael Cano, Peso Pluma.",
            style = MaterialTheme.typography.bodyMedium,
            color = Color.LightGray,
            modifier = Modifier.padding(horizontal = 16.dp)
        )
    }
}
