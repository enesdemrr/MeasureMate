package com.example.measuremate.ui.component

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.ModalBottomSheet
import androidx.compose.material3.SheetState
import androidx.compose.material3.Text
import androidx.compose.material3.rememberModalBottomSheetState
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.PreviewScreenSizes
import androidx.compose.ui.unit.dp

@Composable
@OptIn(ExperimentalMaterial3Api::class)
fun ProfileBottomSheet(
    modifier: Modifier = Modifier,
    sheetState: SheetState,
    onBottomSheetDismiss: () -> Unit,
    isOpen: Boolean,
    buttı
) {
    if (isOpen) {
        ModalBottomSheet(
            modifier = modifier,
            sheetState = sheetState,
            onDismissRequest = { onBottomSheetDismiss() }
        ) {
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(20.dp)
            ) {
                ProfilePicturePlace(
                    placeHolderSize = 30.dp,
                    borderWidth = 1.dp,
                    profilePictureUrl = null,
                    padding = 1.dp
                )
                Text(
                    text = "Anonymous",
                    style = MaterialTheme.typography.bodyLarge
                )
                Text(
                    text = "Anonymous@measuremate.com",
                    style = MaterialTheme.typography.bodyLarge
                )
                GoogleSingInButton(
                    onClick = {},
                    loadingState = ,
                )
            }
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@PreviewScreenSizes
@Composable
fun ProfileBottomSheetPreview() {
    ProfileBottomSheet(
        sheetState = rememberModalBottomSheetState(),
        isOpen = true,
        onBottomSheetDismiss = {}
    )
}