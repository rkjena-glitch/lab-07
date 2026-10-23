package com.example.lab_07

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
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
import androidx.navigation.NavController

@Composable
fun DriversScreen(navController: NavController) {

    var driverName by remember {
        mutableStateOf("")
    }

    val drivers = remember {
        mutableStateListOf<String>()
    }

    Column {

        Button(
            onClick = {
                navController.popBackStack()
            },
            modifier = Modifier.testTag("driverBackButton")
        ) {
            Text("Back")
        }

        Text("FormulaZero Drivers")

        Row {
            TextField(
                value = driverName,
                onValueChange = {
                    driverName = it
                },
                label = {
                    Text("Driver Name")
                },
                modifier = Modifier.testTag("driverInput")
            )

            Button(
                onClick = {
                    if (driverName.isNotBlank()) {
                        drivers.add(driverName)
                        driverName = ""
                    }
                },
                modifier = Modifier.testTag("addDriverButton")
            ) {
                Text("Add")
            }
        }

        Button(
            onClick = {
                drivers.clear()
            },
            modifier = Modifier.testTag("clearDriversButton")
        ) {
            Text("Clear")
        }

        LazyColumn {
            items(drivers) { driver ->
                Text(driver)
            }
        }
    }
}