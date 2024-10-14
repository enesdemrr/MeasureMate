package com.example.measuremate.ui.dashboard

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.tooling.preview.PreviewScreenSizes
import androidx.compose.ui.unit.dp
import com.example.measuremate.ui.component.ProfilePicturePlace

@Composable
fun DashboardScreen() {
    Column(modifier = Modifier.fillMaxSize()) {
        DashboardTopBar(
            profilePictureUrl = "https://upload.wikimedia.org/wikipedia/commons/thumb/3/3a/Cat03.jpg/1200px-Cat03.jpg",
            onProfilePictureClick = {}
        )
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
private fun DashboardTopBar(
    modifier: Modifier = Modifier,
    profilePictureUrl: String?,
    onProfilePictureClick: () -> Unit
) {
    TopAppBar(
        modifier = modifier,
        title = { Text(text = "MeasureMate") },
        actions = {
            IconButton(onClick = { onProfilePictureClick() }) {
                ProfilePicturePlace(
                    placeHolderSize = 30.dp,
                    borderWidth = 1.dp,
                    profilePictureUrl = profilePictureUrl,
                    padding = 1.dp
                )
            }

        }
    )

}


@PreviewScreenSizes
@Composable
fun DashboardScreenPreview() {
    DashboardScreen()
}