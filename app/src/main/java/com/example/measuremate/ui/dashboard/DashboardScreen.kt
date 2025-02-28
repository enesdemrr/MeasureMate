package com.example.measuremate.ui.dashboard

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.ArrowForward
import androidx.compose.material3.Card
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.PreviewScreenSizes
import androidx.compose.ui.unit.dp
import com.example.measuremate.domain.model.BodyPart
import com.example.measuremate.domain.model.User
import com.example.measuremate.domain.model.predefinedBodyParts
import com.example.measuremate.ui.component.MeasureMateDialog
import com.example.measuremate.ui.component.ProfileBottomSheet
import com.example.measuremate.ui.component.ProfilePicturePlace
import com.example.measuremate.ui.theme.MeasureMateTheme

@Composable
fun DashboardScreen() {
    var isProfileBottomSheetOpen by remember { mutableStateOf(false) }
    var isSignOutDialogOpen by rememberSaveable { mutableStateOf(false) }
    val user = User(
        name = "Enes",
        email = "contact@enesdemir.net",
        profilePictureUrl = "https://upload.wikimedia.org/wikipedia/commons/thumb/3/3a/Cat03.jpg/1200px-Cat03.jpg",
        isAnonymous = false
    )
    ProfileBottomSheet(
        isOpen = isProfileBottomSheetOpen,
        user = null,
        onBottomSheetDismiss = {},
        buttonPrimaryText = "Sign out with google",
        onGoogleButtonClick = { isSignOutDialogOpen = true },
        buttonLoadingState = false
    )
    MeasureMateDialog(
        title = "Sign out",
        isOpen = isSignOutDialogOpen,
        onDismissDialog = {},
        body = { Text(text = "Are you sure, you want to sign out?") },
        onConfirmButtonClick = { isSignOutDialogOpen = false },
        onDismissButtonClick = { isSignOutDialogOpen = false }
    )
    Box(
        modifier = Modifier.fillMaxSize()
    ) {
        Column(modifier = Modifier.fillMaxSize()) {
            DashboardTopBar(
                profilePictureUrl = user.profilePictureUrl,
                onProfilePictureClick = { isProfileBottomSheetOpen = true }
            )
            LazyVerticalGrid(
                modifier = Modifier.fillMaxSize(),
                columns = GridCells.Adaptive(minSize = 300.dp),
                contentPadding = PaddingValues(16.dp, top = 8.dp, 16.dp, 16.dp),
                verticalArrangement = Arrangement.spacedBy(12.dp),
                horizontalArrangement = Arrangement.spacedBy(32.dp),
            ) {
                items(predefinedBodyParts) { bodyPart ->
                    ItemCard(bodyPart = bodyPart)
                }
            }
        }
        FloatingActionButton(
            modifier = Modifier
                .align(Alignment.BottomEnd)
                .padding(24.dp),
            onClick = { TODO() }
        ) {
            Icon(imageVector = Icons.Default.Add, contentDescription = "Add Icon")
        }
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

@Composable
private fun ItemCard(
    modifier: Modifier = Modifier,
    bodyPart: BodyPart
) {
    Card(
        modifier = modifier,
        onClick = { TODO() })
    {
        Row(
            modifier = Modifier.padding(16.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text(
                modifier = Modifier.weight(8f),
                text = bodyPart.name,
                style = MaterialTheme.typography.bodyLarge,
                maxLines = 1,
                overflow = TextOverflow.Ellipsis
            )
            Spacer(modifier = Modifier.weight(1f))
            Text(
                text = "${bodyPart.latestValue ?: ""} ${bodyPart.measuringUnit}",
                style = MaterialTheme.typography.bodyLarge
            )
            Spacer(modifier = Modifier.width(10.dp))
            Box(
                modifier = Modifier
                    .clip(CircleShape)
                    .background(MaterialTheme.colorScheme.surface)
                    .padding(4.dp)
            ) {
                Icon(
                    imageVector = Icons.Default.ArrowForward,
                    contentDescription = "Show Details",
                    modifier = Modifier.size(15.dp)
                )
            }
        }
    }
}


@PreviewScreenSizes
@Composable
fun DashboardScreenPreview() {
    MeasureMateTheme {
        DashboardScreen()
    }
}