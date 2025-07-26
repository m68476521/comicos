package com.m68476521.comicos.ui

import androidx.compose.foundation.Image
import androidx.compose.foundation.R
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.lazy.staggeredgrid.LazyVerticalStaggeredGrid
import androidx.compose.foundation.lazy.staggeredgrid.StaggeredGridCells
import androidx.compose.foundation.lazy.staggeredgrid.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import coil3.compose.AsyncImage
import coil3.request.ImageRequest
import coil3.request.crossfade
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
//    LazyColumn(
    LazyVerticalStaggeredGrid(
//        columns = GridCells.Adaptive(minSize = 120.dp),
        columns = StaggeredGridCells.Adaptive(100.dp),
        verticalItemSpacing = 14.dp,
        horizontalArrangement = Arrangement.spacedBy(4.dp),
        content = {
            println("MKE data::::  $result")
            items(result) { currentItem ->
//                val currentItem = result[idx]
                val image = currentItem.thumbnail?.path + "." + currentItem.thumbnail?.extension
                println("MKE ${currentItem.title}")
                println("MKE ${image}")
                MyCardTile(image)

//                AsyncImage(
////                    model = image,
////                    model = rememberAsyncImagePainter(model = image),
//                    model = ImageRequest.Builder(LocalContext.current)
//                        .data(image)
//                        .crossfade(true) // Optional: Adds a crossfade animation
//                        .build(),
//                    contentScale = ContentScale.Crop,
//                    contentDescription = null,
//                    modifier = Modifier
//                        .fillMaxWidth()
//                        .wrapContentHeight()
//                )
            }
        },
        modifier = Modifier
            .background(MaterialTheme.colorScheme.primary)
            .height(100.dp),
    )
//    {
//        items(result, key = { it.id ?: 1 }) { currentItem ->
//        items(result) { currentName ->
//            Text(
//                text = currentItem.title.toString(),
//                color = MaterialTheme.colorScheme.onPrimaryContainer,
//                modifier =
//                    Modifier
//                        .clickable {
//                            itemSelected.invoke(currentItem.title, currentItem.id.toString())
//                        }.fillMaxWidth()
//                        .padding(16.dp),
//            )
//            HorizontalDivider(
//                modifier =
//                    Modifier
//                        .padding(6.dp),
//                thickness = 2.dp,
//            )

//            AsyncImag
//            println("MKE ${currentItem.title}")
//            val image = currentItem.thumbnail?.path + "." + currentItem.thumbnail?.extension
//            println("MKE ${image}")
//
//            AsyncImage(
//                model = image,
//                contentScale = ContentScale.Inside,
//                contentDescription = null,
//                modifier = Modifier
//                    .fillMaxWidth()
//                    .height(100.dp)
//                    .padding(4.dp)
//                        .clickable {
//
//                        }
//            )
//        }
//    }
}

@Composable
fun MyCardTile(imgUrl: String) {
    Box(modifier = Modifier
        .background(MaterialTheme.colorScheme.error)
        .fillMaxWidth()) {

        println("   MKE imgUrl:: $imgUrl")
        AsyncImage(
//            model = ImageRequest.Builder(LocalContext.current)
////                .data("https://i.imgur.com/KsFOIGU.jpeg")
//                .data("http://i.annihil.us/u/prod/marvel/i/mg/4/20/4bc697c680890.jpg")
//                //https://upload.wikimedia.org/wikipedia/commons/b/b2/JPEG_compression_Example.jpg
//                .crossfade(true) // Optional: Adds a crossfade animation
//                .build(),
            model = "http://i.annihil.us/u/prod/marvel/i/mg/4/20/4bc697c680890.jpg",
//            model  = "https://upload.wikimedia.org/wikipedia/commons/b/b2/JPEG_compression_Example.jpg",
            contentDescription = "Image loaded from URL", // Provide a meaningful description for accessibility
//            modifier = Modifier.fillMaxWidth(0.5f).height(100.dp)
//            contentScale = ContentScale.Crop,
            modifier = Modifier
            .fillMaxWidth(0.8f)
            .height(134.dp)
        )

//        AsyncImage(
//            model = ImageRequest.Builder(LocalContext.current)
//                .data("https://i.imgur.com/KsFOIGU.jpeg")
//                .crossfade(true)
//                .build(),
////            placeholder = painterResource(id = R.drawable.ic_launcher_foreground),
//            contentDescription = stringResource(com.m68476521.comicos.R.string.comicos),
//            contentScale = ContentScale.Crop,
//            modifier = Modifier.clip(CircleShape)
//        )

//        Box(modifier = Modifier
//            .fillMaxWidth(0.9f)
//            .height(134.dp)
//            .background(MaterialTheme.colorScheme.outline))
    }
}
