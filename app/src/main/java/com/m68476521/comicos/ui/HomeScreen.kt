package com.m68476521.comicos.ui

import androidx.compose.animation.AnimatedContentScope
import androidx.compose.animation.ExperimentalSharedTransitionApi
import androidx.compose.animation.SharedTransitionScope
import androidx.compose.animation.core.tween
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.lazy.staggeredgrid.LazyVerticalStaggeredGrid
import androidx.compose.foundation.lazy.staggeredgrid.StaggeredGridCells
import androidx.compose.foundation.lazy.staggeredgrid.items
import androidx.compose.foundation.lazy.staggeredgrid.rememberLazyStaggeredGridState
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Shadow
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil3.compose.AsyncImage
import coil3.request.CachePolicy
import coil3.request.ImageRequest
import coil3.request.crossfade
import com.m68476521.comicos.R
import com.m68476521.comicos.home.data.HomeIntent
import com.m68476521.comicos.model.MyModel

@OptIn(ExperimentalSharedTransitionApi::class)
@Composable
fun HomeScreen(
    viewModel: MyModel,
    animatedContentScope: AnimatedContentScope,
    sharedTransitionScope: SharedTransitionScope,
    itemSelected: (image: String, id: String?) -> Unit,
) {
    val state by viewModel.state.collectAsState()

    LaunchedEffect(key1 = Unit) {
        if (state.comicsResponse == null) {
            viewModel.handleIntent(HomeIntent.LoadComics)
        }
    }

    val result = state.comicsResponse?.data?.results ?: return
    val listState = rememberLazyStaggeredGridState()

    Surface(
        modifier = Modifier.fillMaxSize()
    ) {

        LazyVerticalStaggeredGrid(
            columns = StaggeredGridCells.Fixed(3),
            verticalItemSpacing = 4.dp,
            horizontalArrangement = Arrangement.spacedBy(4.dp),
            contentPadding = PaddingValues(10.dp),
            state = listState,
            modifier = Modifier
                .fillMaxSize()
                .padding(horizontal = 4.dp)
                .height(100.dp), // TODO remote this line and figured out why this need to be fixed to 100
        ) {
            items(items = result, key = { it.id ?: it.upc ?: "" }) { currentItem ->
                val image = currentItem.thumbnail?.path + "." + currentItem.thumbnail?.extension
                if (image.startsWith("http:")) {
                    image.replace("http:", "https:")
                }

                Card(
                    modifier = Modifier
                        .fillMaxWidth(),
                    elevation = CardDefaults.cardElevation(4.dp),
                    onClick = {
                        itemSelected.invoke(image, currentItem.id.toString())
                    }
                ) {

                    Box(
                        modifier = Modifier.fillMaxSize()
                    ) {
                        with(sharedTransitionScope) {
                            val request: ImageRequest =
                                ImageRequest.Builder(LocalContext.current.applicationContext)
                                    .data(image)
                                    .crossfade(true)
                                    .diskCacheKey(image)
                                    .diskCachePolicy(CachePolicy.ENABLED)
                                    .build()

                            AsyncImage(
                                model = request,
                                contentDescription = null,
                                contentScale = ContentScale.Crop,
                                placeholder = painterResource(R.drawable.ic_launcher_background),
                                modifier = Modifier
                                    .fillMaxWidth()
                                    .wrapContentHeight()
                                    .sharedElement(
                                        sharedContentState = rememberSharedContentState("image/${currentItem.id}"),
                                        animatedVisibilityScope = animatedContentScope,
                                        boundsTransform = { _, _ ->
                                            tween(durationMillis = 1000)
                                        }
                                    )
                            )
                        }

                        Text(
                            text = currentItem.title ?: "",
                            style = TextStyle(
                                color = MaterialTheme.colorScheme.onSurface,
                                fontSize = 14.sp,
                                shadow = Shadow(
                                    color = MaterialTheme.colorScheme.onSurface.copy(alpha = 0.7f),
                                    offset = Offset(5f, 5f),
                                    blurRadius = 8f
                                )
                            ),
                            maxLines = 2,
                            overflow = TextOverflow.Ellipsis,
                            fontWeight = FontWeight.Bold,
                            modifier = Modifier
                                .padding(4.dp)
                                .align(Alignment.BottomCenter)
                        )
                    }
                }
            }
        }
    }
}

