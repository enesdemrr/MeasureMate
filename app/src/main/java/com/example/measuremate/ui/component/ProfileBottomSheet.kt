package com.example.measuremate.ui.component

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.BottomSheetDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.ModalBottomSheet
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.measuremate.domain.model.User

@Composable
@OptIn(ExperimentalMaterial3Api::class)
fun ProfileBottomSheet(
    modifier: Modifier = Modifier,
    onBottomSheetDismiss: () -> Unit,
    user: User?,
    isOpen: Boolean,
    buttonLoadingState: Boolean,
    buttonPrimaryText: String,
    onGoogleButtonClick: () -> Unit,

    ) {
    if (isOpen) {
        ModalBottomSheet(
            modifier = modifier,
            onDismissRequest = { onBottomSheetDismiss() },
            dragHandle = {
                Column(
                    modifier = Modifier
                        .fillMaxWidth(),
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    BottomSheetDefaults.DragHandle()
                    Text(
                        text = "Profile",
                        style = MaterialTheme.typography.titleLarge
                    )
                    Spacer(modifier = Modifier.height(10.dp))
                    HorizontalDivider()
                }
            }
        ) {
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(20.dp),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                ProfilePicturePlace(
                    placeHolderSize = 30.dp,
                    borderWidth = 1.dp,
                    profilePictureUrl = user?.profilePictureUrl,
                    padding = 1.dp
                )
                Spacer(modifier = Modifier.height(10.dp))
                Text(
                    text = if (user == null || user.isAnonymous) "Anonymous" else user.name,
                    style = MaterialTheme.typography.bodyLarge
                )
                Spacer(modifier = Modifier.height(4.dp))
                Text(
                    text =if (user == null || user.isAnonymous) "Anonymous@measuremate.com" else user.email,
                    style = MaterialTheme.typography.bodyLarge
                )
                Spacer(modifier = Modifier.height(4.dp))
                GoogleSingInButton(
                    onClick = onGoogleButtonClick,
                    loadingState = buttonLoadingState,
                    primaryText = buttonPrimaryText,
                )
            }
        }
    }
}