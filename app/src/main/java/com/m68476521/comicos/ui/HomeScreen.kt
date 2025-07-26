package com.m68476521.comicos.ui

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.lazy.staggeredgrid.LazyVerticalStaggeredGrid
import androidx.compose.foundation.lazy.staggeredgrid.StaggeredGridCells
import androidx.compose.foundation.lazy.staggeredgrid.items
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.dp
import coil3.compose.AsyncImage
import com.m68476521.comicos.model.MyModel

@Composable
fun HomeScreen(
    viewModel: MyModel,
    itemSelected: (result: String?, albumId: String?) -> Unit,
) {
    val data by viewModel.comicsResponseData.collectAsState()

    LaunchedEffect(key1 = Unit) {
        viewModel.getData()
    }

    val result = data.data?.results ?: return

    LazyVerticalStaggeredGrid(
        columns = StaggeredGridCells.Fixed(3),
        verticalItemSpacing = 4.dp,
        horizontalArrangement = Arrangement.spacedBy(4.dp),
        content = {
            items(result) { currentItem ->
                var image = currentItem.thumbnail?.path + "." + currentItem.thumbnail?.extension
                if (image.startsWith("http:")) {
                    image.replace("http:", "https:")
                }

                Card(
                    modifier = Modifier
                        .fillMaxWidth(),
                    elevation = CardDefaults.cardElevation(4.dp),
                    onClick = {
                        itemSelected.invoke(currentItem.title, currentItem.id.toString())
                    }
                ) {
                    AsyncImage(
                        model = image,
                        contentDescription = null,
                        contentScale = ContentScale.Crop,
                        modifier = Modifier
                            .fillMaxWidth()
                            .wrapContentHeight()
                    )
                }
            }
        },
        modifier = Modifier
            .fillMaxSize()
            .padding(horizontal = 4.dp)
            .height(100.dp),
    )
}
