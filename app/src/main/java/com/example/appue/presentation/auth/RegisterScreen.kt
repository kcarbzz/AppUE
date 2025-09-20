package com.example.appue.presentation.auth

import android.widget.MediaController
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController

@Composable
fun RegisterScreen(navController: NavController){
    var name by remember { mutableStateOf("") }
    var email by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }
    var confirmpassword by remember { mutableStateOf("") }

    Column(
        modifier = Modifier.padding(16.dp)
    ) {

        Text("Registrarse", style = MaterialTheme.typography.titleLarge)

        OutlinedTextField(
            value = name,
            onValueChange = { name = it },
            label = { Text("Nombre") },
            placeholder = { Text("Ingrese su Nombre") },
            modifier = Modifier.padding(vertical = 16.dp)
        )
        OutlinedTextField(
            value = email,
            onValueChange = { email = it },
            label = { Text("Correo electrónico") },
            placeholder = { Text("Ingrese su correo electrónico") },
            modifier = Modifier.padding(vertical = 16.dp)
        )

        OutlinedTextField(
            value = password,
            onValueChange = { password = it },
            label = { Text("Contraseña") },
            placeholder = { Text("Ingrese su contraseña") },
            modifier = Modifier.padding(vertical = 16.dp)
        )
        OutlinedTextField(
            value = confirmpassword,
            onValueChange = { confirmpassword = it },
            label = { Text("Contraseña") },
            placeholder = { Text("Ingrese su contraseña de nuevo") },
            modifier = Modifier.padding(vertical = 16.dp)
        )
        Spacer(modifier = Modifier.height(16.dp))
        Button(onClick = {
        if(email.isNotBlank() && password.isNotBlank() && confirmpassword == password ){
            navController.navigate("login")
        }
        /* TODO */ },
        ) {
            Text("Registrar")
        }

    }
}