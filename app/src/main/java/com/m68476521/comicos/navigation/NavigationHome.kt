package com.m68476521.comicos.navigation

import androidx.compose.animation.AnimatedContentScope
import androidx.compose.animation.ExperimentalSharedTransitionApi
import androidx.compose.animation.SharedTransitionScope
import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavOptions
import androidx.navigation.compose.composable
import com.m68476521.comicos.model.MyModel
import com.m68476521.comicos.ui.HomeScreen

fun NavController.navigateToHomeScreen(navOptions: NavOptions? = null) {
    this.navigate(ScreenHome, navOptions)
}

@OptIn(ExperimentalSharedTransitionApi::class)
fun NavGraphBuilder.homeViewerScreen(
    viewModel: MyModel,
    animatedContentScope: AnimatedContentScope,
    sharedTransitionScope: SharedTransitionScope,
    navigateToDetailsScreen: (image: String?, albumId: String?) -> Unit,
) {
    composable<ScreenHome> {
        HomeScreen(
            viewModel = viewModel,
            animatedContentScope = animatedContentScope,
            sharedTransitionScope = sharedTransitionScope
        ) { image, albumId ->
            navigateToDetailsScreen.invoke(image, albumId)
        }
    }
}
