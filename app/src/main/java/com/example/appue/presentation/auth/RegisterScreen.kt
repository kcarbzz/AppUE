package com.kcarbzz.appue.presentation.auth

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun RegisterScreen(
    // ACEPTAMOS el callback de navegación
    onSuccessfulRegistration: () -> Unit 
) {
    Column {
        Text("PANTALLA DE REGISTRO - AppUE")
        Spacer(modifier = Modifier.height(16.dp))
        Text("Ingresa tus credenciales...")
        
        // ... (Aquí iría la implementación de TextField, PasswordField, etc.) ...
        
        Spacer(modifier = Modifier.height(32.dp))
        
        Button(
            onClick = {
                // *** SIMULACIÓN DE LÓGICA DE REGISTRO ***
                val isSuccess = true 
                
                if (isSuccess) {
                    // Si es exitoso, llama al callback para navegar
                    onSuccessfulRegistration() 
                }
            }
        ) {
            Text("Registrarse y Entrar")
        }
    }
}
