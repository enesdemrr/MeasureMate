package com.example.measuremate.ui.component

import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.PreviewScreenSizes
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import coil3.compose.AsyncImage
import coil3.request.ImageRequest
import coil3.request.crossfade
import com.example.measuremate.R
import com.example.measuremate.ui.theme.tertiaryContainerLight
import com.example.measuremate.ui.theme.tertiaryLight

@Composable
fun ProfilePicturePlace(
    modifier: Modifier = Modifier,
    placeHolderSize: Dp,
    borderWidth: Dp,
    padding: Dp,
    profilePictureUrl: String?
) {
    val imageRequest = ImageRequest
        .Builder(LocalContext.current)
        .data(profilePictureUrl)
        .crossfade(true)
        .build()
    Box(
        modifier = modifier
            .size(placeHolderSize)
            .border(
                width = borderWidth,
                brush = Brush.linearGradient(listOf(tertiaryLight, tertiaryContainerLight)),
                shape = CircleShape
            )
            .padding(padding)
    ) {
        AsyncImage(
            modifier = Modifier
                .fillMaxSize()
                .clip(CircleShape),
            model = imageRequest,
            contentDescription = "Profile Picture",
            contentScale = ContentScale.Crop,
            placeholder = painterResource(id = R.drawable.app_logo),
            error = painterResource(id = R.drawable.app_logo)
        )
    }
}

@PreviewScreenSizes
@Composable
fun ProfilePicturePlacePreview() {
    ProfilePicturePlace(
        placeHolderSize = 30.dp,
        borderWidth = 1.dp,
        profilePictureUrl = null,
        padding = 1.dp
    )
}