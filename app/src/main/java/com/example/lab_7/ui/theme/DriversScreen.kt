package com.example.lab_7.ui.theme

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController

@Composable
fun DriversScreen(navController: NavController) {
    var name by remember {mutableStateOf("")}
    val drivers = remember {mutableStateListOf<String>()}

    Column(modifier = Modifier.fillMaxSize().padding(16.dp)) {
        Button(
            onClick = {navController.popBackStack()},
            modifier = Modifier.testTag("backButton")
        ) {
            Text("Back")
        }

        Spacer(modifier = Modifier.height(16.dp))
        Text(text = "FormulaZero Drivers", fontSize = 30.sp)
        Spacer(modifier = Modifier.height(16.dp))

        Row {
            TextField(
                value = name,
                onValueChange = {name = it},
                label = {Text("Driver Name")},
                modifier = Modifier.testTag("driverInput")
            )
            Button(
                onClick = {
                    if (name.isNotBlank()){
                        drivers.add(name)
                        name = ""
                    }
                },
                modifier = Modifier.testTag("addDriverButton")
            ) {
                Text("Add")
            }
        }

        Spacer(modifier = Modifier.height(16.dp))

        Button(
            onClick = {drivers.clear()},
            modifier = Modifier.testTag("clearButton")
        ) {
            Text("Clear")
        }
        LazyColumn {
            items(drivers) {driver ->
                Text(text = driver, fontSize = 24.sp)
            }
        }
    }
}