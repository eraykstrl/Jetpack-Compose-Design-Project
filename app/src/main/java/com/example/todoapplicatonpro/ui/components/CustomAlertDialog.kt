package com.example.todoapplicatonpro.ui.components

import androidx.compose.foundation.clickable
import androidx.compose.runtime.Composable
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Text
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import com.example.todoapplicatonpro.R

@Composable
fun CustomAlertDialog(
    show : Boolean,
    onDismiss : () -> Unit,
    onConfirm : () -> Unit,
    message : String,
) {
    if(show)
    {
        AlertDialog(
            onDismissRequest = {
                onDismiss()
            },
            dismissButton = {
                Text(
                    text = stringResource(id = R.string.alert_cancel),
                    modifier = Modifier
                        .clickable{
                            onDismiss()
                        }
                )
            },
            title = {
                Text(
                    text = stringResource(id = R.string.alert_update_title),
                    fontSize = 24.sp,
                    fontWeight = FontWeight.Bold
                )
            },
            confirmButton = {
                Text(
                    text = stringResource(id = R.string.alert_apply),
                    modifier = Modifier
                        .clickable{
                            onConfirm()
                        }
                )
            },
            text = {
                Text(
                    text = message,
                    fontSize = 20.sp
                )
            }
        )
    }
}