package com.example.measuremate.ui.additem

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Switch
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.PreviewScreenSizes
import androidx.compose.ui.unit.dp
import com.example.measuremate.domain.model.predefinedBodyParts
import com.example.measuremate.ui.component.MeasureMateDialog

@Composable
fun AddItemScreen() {
    var isAddNewItemDialogOpen by rememberSaveable { mutableStateOf(false) }

    MeasureMateDialog(
        title = "Add New Item",
        isOpen = isAddNewItemDialogOpen,
        onDismissDialog = {},
        confirmButtonText = "Save",
        body = {
            OutlinedTextField(
                value = "",
                onValueChange = {}
            )
        },
        onConfirmButtonClick = { isAddNewItemDialogOpen = false },
        onDismissButtonClick = { isAddNewItemDialogOpen = false }
    )
    Column(modifier = Modifier.fillMaxSize())
    {
        AddItemTopBar(onAddItemClick = { isAddNewItemDialogOpen = true }, onBackIconClick = {})
        LazyVerticalGrid(
            modifier = Modifier.fillMaxSize(),
            columns = GridCells.Adaptive(minSize = 300.dp),
            contentPadding = PaddingValues(16.dp),
            verticalArrangement = Arrangement.spacedBy(12.dp),
            horizontalArrangement = Arrangement.spacedBy(32.dp),
        ) {
            items(predefinedBodyParts) { bodyPart ->
                ItemCard(
                    name = bodyPart.name,
                    isChecked = bodyPart.isActive,
                    onCheckedChange = {},
                    onClick = {}
                )
            }
        }
    }


}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
private fun AddItemTopBar(
    modifier: Modifier = Modifier,
    onAddItemClick: () -> Unit,
    onBackIconClick: () -> Unit
) {
    TopAppBar(
        modifier = modifier,
        title = { Text(text = "MeasureMate") },
        navigationIcon = {
            IconButton(onClick = { onBackIconClick() }) {
                Icon(
                    imageVector = Icons.AutoMirrored.Filled.ArrowBack,
                    contentDescription = "Navigate Back"
                )
            }
        },
        actions = {
            IconButton(onClick = { onAddItemClick() }) {
                Icon(imageVector = Icons.Default.Add, contentDescription = "Add New Item")
            }

        }
    )
}

@Composable
private fun ItemCard(
    modifier: Modifier = Modifier,
    name: String,
    onClick: () -> Unit,
    isChecked: Boolean,
    onCheckedChange: () -> Unit
) {
    Box(
        modifier = modifier.clickable { onClick() }
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text(
                modifier = Modifier.weight(8f),
                text = name,
                style = MaterialTheme.typography.bodyLarge,

                )
            Spacer(modifier = Modifier.weight(1f))
            Switch(checked = isChecked, onCheckedChange = { onCheckedChange() })
        }
    }
}

@PreviewScreenSizes
@Composable
private fun AddItemScreenPreview() {
    AddItemScreen()
}