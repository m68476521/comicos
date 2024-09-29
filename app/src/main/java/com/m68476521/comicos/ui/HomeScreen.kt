package com.m68476521.comicos.ui

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.m68476521.comicos.model.MyModel

@Composable
    fun HomeScreen(navController: NavController, viewModel: MyModel) {
    val data by viewModel.comicsResponseData.collectAsState()

    LaunchedEffect(key1 = Unit) {
        viewModel.getData()
    }

    val result = data.data?.results ?: return
    LazyColumn(
        modifier = Modifier
            .height(100.dp)
    ) {

        items(result) { currentName ->
            Text(
                text = currentName.title.toString(),
                color = Color.White,
                modifier = Modifier
                    .clickable {
                        navController.navigate(ComicosScreen.Flavor.name)
                    }
                    .fillMaxWidth()
                    .padding(16.dp)
            )
            HorizontalDivider(
                modifier = Modifier
                    .padding(6.dp),
                thickness = 2.dp
            )
        }
    }
}