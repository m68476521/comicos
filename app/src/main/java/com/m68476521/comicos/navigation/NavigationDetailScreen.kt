package com.m68476521.comicos.navigation

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavOptions
import androidx.navigation.compose.composable
import androidx.navigation.toRoute
import com.m68476521.comicos.model.MyModel
import com.m68476521.comicos.ui.DetailViewerScreen

fun NavController.navigateToDetailViewerScreen(
    navOptions: NavOptions? = null,
    albumId: String,
    albumName: String
) {
    //handlePopBackStack(this)
    println("MKE albumId $albumId albumName $albumName")
    this.navigate(ScreenDetail(albumId, albumName))
}

fun NavGraphBuilder.detailViewerScreen(
    defaultAlbumId: String?,
    defaultAlbumName: String?,
    viewModel: MyModel
) {
    println("MKE ::: $defaultAlbumId $defaultAlbumName")

    composable<ScreenDetail> {
        val args = it.toRoute<ScreenDetail>()
        DetailViewerScreen(
            viewModel = viewModel, subtotal = args.albumId + args.albumName
        )
    }
}