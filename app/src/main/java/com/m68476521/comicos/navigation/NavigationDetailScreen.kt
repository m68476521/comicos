package com.m68476521.comicos.navigation

import androidx.compose.animation.AnimatedContentScope
import androidx.compose.animation.ExperimentalSharedTransitionApi
import androidx.compose.animation.SharedTransitionScope
import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavOptions
import androidx.navigation.compose.composable
import androidx.navigation.toRoute
import com.m68476521.comicos.model.MyModel
import com.m68476521.comicos.ui.DetailViewerScreen

fun NavController.navigateToDetailViewerScreen(
    navOptions: NavOptions? = null,
    image: String,
    albumName: String,

) {
    this.navigate(ScreenDetail(image, albumName))
}

@OptIn(ExperimentalSharedTransitionApi::class)
fun NavGraphBuilder.detailViewerScreen(
    image: String,
    defaultAlbumName: String?,
    viewModel: MyModel,
    animatedContentScope: AnimatedContentScope,
    sharedTransitionScope: SharedTransitionScope,
    onBack: () -> Unit,
) {
    composable<ScreenDetail> {
        val args = it.toRoute<ScreenDetail>()
        DetailViewerScreen(
            viewModel = viewModel,
            image = args.image,
            animatedContentScope = animatedContentScope,
            sharedTransitionScope = sharedTransitionScope,
        ) {
            onBack()
        }
    }
}
