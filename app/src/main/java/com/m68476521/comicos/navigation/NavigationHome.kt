package com.m68476521.comicos.navigation

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavOptions
import androidx.navigation.compose.composable
import com.m68476521.comicos.model.MyModel
import com.m68476521.comicos.ui.HomeScreen

fun NavController.navigateToHomeScreen(navOptions: NavOptions? = null) {
    // handlePopBackStack(this)
    this.navigate(ScreenHome, navOptions)
}

fun NavGraphBuilder.homeViewerScreen(
    viewModel: MyModel,
    navigateToDetailsScreen: (name: String?, albumId: String?) -> Unit,
) {
    composable<ScreenHome> {
        HomeScreen(viewModel) { name, albumId ->
            navigateToDetailsScreen.invoke(name, albumId)
        }
    }
}
