package com.example.measuremate.ui.signin

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.windowsizeclass.WindowWidthSizeClass
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.tooling.preview.PreviewScreenSizes
import androidx.compose.ui.unit.dp
import com.example.measuremate.R
import com.example.measuremate.ui.component.AnonymousSignInButton
import com.example.measuremate.ui.component.GoogleSingInButton
import com.example.measuremate.ui.component.MeasureMateDialog
import com.example.measuremate.ui.theme.MeasureMateTheme

@Composable
fun SingInScreen(
    windowSize: WindowWidthSizeClass
) {
    var isSignInAnonymousDialogOpen by rememberSaveable { mutableStateOf(false) }
    MeasureMateDialog(
        title = "Login Anonymously",
        isOpen = isSignInAnonymousDialogOpen,
        onDismissDialog = {},
        body = { Text(text = "By logging in anonymously, you will not be able to synchronize the data,") },
        onConfirmButtonClick = {isSignInAnonymousDialogOpen = false},
        onDismissButtonClick = {isSignInAnonymousDialogOpen = false}
    )
    when (windowSize) {
        WindowWidthSizeClass.Compact -> {
            Column(
                modifier = Modifier.fillMaxSize(),
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Center
            ) {
                Image(
                    painter = painterResource(id = R.drawable.app_logo),
                    contentDescription = "App Logo",
                    modifier = Modifier.size(120.dp)
                )
                Spacer(modifier = Modifier.height(20.dp))
                Text(
                    text = "MeasureMate",
                    style = MaterialTheme.typography.headlineLarge
                )
                Text(
                    text = "Measure progress, not perfection",
                    style = MaterialTheme.typography.bodySmall.copy(fontStyle = FontStyle.Italic)
                )
                Spacer(modifier = Modifier.fillMaxHeight(fraction = 0.4f))
                GoogleSingInButton(
                    onClick = { }
                )
                Spacer(modifier = Modifier.height(20.dp))
                AnonymousSignInButton(
                    onClick = { isSignInAnonymousDialogOpen = true }
                )

            }
        }

        else -> {
            Row(
                modifier = Modifier.fillMaxSize()
            ) {
                Column(
                    modifier = Modifier
                        .fillMaxHeight()
                        .weight(1f),
                    horizontalAlignment = Alignment.CenterHorizontally,
                    verticalArrangement = Arrangement.Center
                ) {
                    Image(
                        painter = painterResource(id = R.drawable.app_logo),
                        contentDescription = "App Logo",
                        modifier = Modifier.size(120.dp)
                    )
                    Spacer(modifier = Modifier.height(20.dp))
                    Text(
                        text = "MeasureMate",
                        style = MaterialTheme.typography.headlineLarge
                    )
                    Text(
                        text = "Measure progress, not perfection",
                        style = MaterialTheme.typography.bodySmall.copy(fontStyle = FontStyle.Italic)
                    )
                }
                Column(
                    modifier = Modifier
                        .fillMaxHeight()
                        .weight(1f),
                    horizontalAlignment = Alignment.CenterHorizontally,
                    verticalArrangement = Arrangement.Center
                ) {
                    GoogleSingInButton(
                        onClick = { }
                    )
                    Spacer(modifier = Modifier.height(20.dp))
                    AnonymousSignInButton(
                        onClick = { }
                    )
                }

            }
        }
    }

}

@PreviewScreenSizes
@Composable
private fun SignInScreenPreview() {
    MeasureMateTheme {
        SingInScreen(WindowWidthSizeClass.Medium)
    }
}