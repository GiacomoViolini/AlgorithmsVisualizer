package com.example.algovis.components

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.DropdownMenu
import androidx.compose.material.DropdownMenuItem
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.algovis.MainActivity

@Composable
fun AlgorithmSelectionDropdown(
    selectedAlgorithm: MainActivity.Algorithm,
    onAlgorithmSelected: (MainActivity.Algorithm) -> Unit
) {

    var expanded by remember{ mutableStateOf(true)}

    Column {
        // Dropdown button
        Button(
            colors = ButtonDefaults.buttonColors(
                backgroundColor = Color(0xfff6aa1c),
                contentColor = Color.White,
            ),
            onClick = {expanded = !expanded},
            modifier = Modifier
                .fillMaxWidth()
                .padding(10.dp)
        ){
            Text(
                text =selectedAlgorithm.name,
                style = TextStyle(
                    fontWeight = FontWeight.Bold,
                    fontSize = 20.sp
                ))
        }

        // Dropdown menu
        DropdownMenu(
            expanded = expanded, // Use a state variable to control this
            onDismissRequest = { expanded = false},
            modifier = Modifier.fillMaxWidth().background(Color(0xfff6aa1c))
        ) {
            MainActivity.Algorithm.values().forEach { algorithm ->
                DropdownMenuItem(
                    onClick = {
                        expanded = false
                        onAlgorithmSelected(algorithm)
                    },
                    modifier = Modifier
                        .fillMaxWidth()
                        .background(Color(0xffff8500))
                ) {
                    Text(
                        text = algorithm.name,
                        style = TextStyle(
                            color = Color.White, // Text color
                            fontWeight = FontWeight.SemiBold,
                            fontSize = 20.sp
                        ),
                        modifier = Modifier.padding(12.dp) // Item padding
                    )
                }
            }
        }
    }
}