package com.example.measuremate.ui.component

import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.PreviewScreenSizes

@Composable
fun MeasureMateDialog(
    modifier: Modifier = Modifier,
    isOpen: Boolean,
    confirmButtonText: String = "Yes",
    dismissButtonText: String = "Cancel",
    title: String,
    body: @Composable (() -> Unit)? = null,
    onDismissDialog: () -> Unit,
    onConfirmButtonClick: () -> Unit,
    onDismissButtonClick: () -> Unit,
) {
    if (isOpen) {
        AlertDialog(
            modifier = modifier,
            title = { Text(text = title) },
            text = body,
            onDismissRequest = { onDismissDialog() },
            confirmButton = {
                TextButton(onClick = { onConfirmButtonClick() }) {
                    Text(text = confirmButtonText)
                }
            },
            dismissButton = {
                TextButton(onClick = { onDismissButtonClick() }) {
                    Text(text = dismissButtonText)
                }
            }
        )
    }

}

@PreviewScreenSizes
@Composable
fun MeasureMateDialogPreview() {
    MeasureMateDialog(
        title = "Login Anonymously",
        isOpen = true,
        onDismissDialog = {},
        body = { Text(text = "By logging in anonymously, you will not be able to synchronize the data,") },
        onConfirmButtonClick = {},
        onDismissButtonClick = {}
    )
}
