package com.m68476521.comicos.ui

import androidx.compose.animation.AnimatedContentScope
import androidx.compose.animation.ExperimentalSharedTransitionApi
import androidx.compose.animation.SharedTransitionScope
import androidx.compose.animation.core.spring
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import coil3.compose.AsyncImage
import com.m68476521.comicos.model.MyModel

@OptIn(ExperimentalSharedTransitionApi::class)
@Composable
fun DetailViewerScreen(
    viewModel: MyModel,
    id: String = "",
    image: String = "",
    animatedContentScope: AnimatedContentScope,
    sharedTransitionScope: SharedTransitionScope,
    onBack: () -> Unit,
) {
    val state by viewModel.state.collectAsState()

    with(sharedTransitionScope) {
        Column(
            modifier = Modifier
                .sharedBounds(
                    sharedContentState = rememberSharedContentState("bounds"),
                    animatedVisibilityScope = animatedContentScope,
                    resizeMode = SharedTransitionScope.ResizeMode.RemeasureToBounds,
                )
                .fillMaxSize(),
        ) {
            Box(
                modifier = Modifier
                    .fillMaxSize()
                    .clickable {
                        onBack()
                    }

            ) {
                AsyncImage(
                    model = image,
                    contentDescription = null,
                    contentScale = ContentScale.Crop,
                    modifier = Modifier
                        .fillMaxWidth()
                        .wrapContentHeight()
                        .sharedElement(
                            sharedContentState = rememberSharedContentState("image/$id"),
                            animatedVisibilityScope = animatedContentScope,
                            boundsTransform = { _, _ ->
                                spring(
                                    dampingRatio = 0.6f,
                                    stiffness = 380f,
                                )
                            }
                        )
                )
            }

            Text(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(16.dp)
                    .align(Alignment.CenterHorizontally)
                    .skipToLookaheadSize()
                    .sharedElement(
                        sharedContentState = rememberSharedContentState("text/$id"),
                        animatedVisibilityScope = animatedContentScope,
                        boundsTransform = { _, _ ->
                            spring(
                                dampingRatio = 0.6f,
                                stiffness = 380f,
                            )
                        }
                    ),
                text = state.currentComicSelected?.title ?: "",
                maxLines = 2,
                overflow = TextOverflow.Ellipsis,
                fontWeight = FontWeight.Bold,
            )
        }
    }
}
