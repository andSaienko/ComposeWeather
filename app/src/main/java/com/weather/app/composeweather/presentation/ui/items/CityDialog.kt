package com.weather.app.composeweather.presentation.ui.items

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalSoftwareKeyboardController
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.DialogProperties

@OptIn(ExperimentalComposeUiApi::class, ExperimentalMaterial3Api::class)
@Composable
fun InputCityDialog(
    onDismiss: () -> Unit,
    onConfirm: (String) -> Unit,
) {
    var inputText by remember { mutableStateOf(TextFieldValue()) }
    val keyboardController = LocalSoftwareKeyboardController.current

    AlertDialog(
        onDismissRequest = onDismiss,
        properties = DialogProperties(dismissOnClickOutside = true),
    ) {
        Column(
            modifier = Modifier
                .width(300.dp)
                .padding(16.dp)
                .clip(RoundedCornerShape(16.dp))
        ) {
            TextField(
                label = { Text(text = "Input your city here") },
                value = inputText,
                onValueChange = {
                    inputText = it
                }, keyboardOptions = KeyboardOptions.Default.copy(
                    imeAction = ImeAction.Done
                ), keyboardActions = KeyboardActions(
                    onDone = {
                        onConfirm(inputText.text)
                        keyboardController?.hide()
                    }), modifier = Modifier
                    .fillMaxWidth()
                    .background(Color.White),
                singleLine = true
            )


            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .background(Color(0x80000000)),
                horizontalArrangement = Arrangement.End
            ) {
                Button(modifier = Modifier.padding(vertical = 8.dp),
                    colors = ButtonDefaults.buttonColors(Color.Transparent),
                    onClick = {
                        onConfirm(inputText.text)
                        keyboardController?.hide()
                    }) {
                    Text("OK")
                }

                Button(modifier = Modifier.padding(8.dp),
                    colors = ButtonDefaults.buttonColors(Color.Transparent),
                    onClick = {
                        onDismiss()
                        keyboardController?.hide()
                    }) {
                    Text("Cancel")
                }
            }
        }
    }
}