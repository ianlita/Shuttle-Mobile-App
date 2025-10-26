package com.example.shuttleapp.presentation.components

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.KeyboardType

@Composable
fun ModifiedTextField(label: String, errorIndicator: Boolean, value: String, onValueChanged: (String) -> Unit) {

    OutlinedTextField(
        value = value,
        onValueChange = {newValue ->
            onValueChanged(newValue)
        },
        isError = errorIndicator,
        label = { Text(label) },
        singleLine = true,
        modifier = Modifier
            .fillMaxWidth(),
        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Text)
    )
}

//@Composable
//fun ModifiedTextField(label: String, value: String, onValueChange: (String) -> Unit) {
//
//    androidx.compose.material.OutlinedTextField(
//        value = value,
//        label = { Text(label, color = Black) },
//        onValueChange = onValueChange,
//        modifier = Modifier.fillMaxWidth(),
//        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Text),
//        colors = TextFieldDefaults.outlinedTextFieldColors(
//            textColor = Black,
//            focusedLabelColor = Gray,
//            unfocusedLabelColor = Gray,
//            cursorColor = NavyBlue,
//            focusedBorderColor = Gray,
//            unfocusedBorderColor = Gray
//        )
//    )
//}
