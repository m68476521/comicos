package com.m68476521.comicos

import ComicosApp
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.core.splashscreen.SplashScreen.Companion.installSplashScreen
import com.m68476521.comicos.model.MyModel
import comicosTheme
import dagger.hilt.android.AndroidEntryPoint
import timber.log.Timber

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    private val viewModel: MyModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        if (BuildConfig.DEBUG) {
            Timber.plant(Timber.DebugTree())
        }
        installSplashScreen().apply {
            setKeepOnScreenCondition {
                viewModel.comicsResponseData.value.data == null
            }
        }
        setContent {
            comicosTheme {
                ComicosApp()
            }
        }
    }
}
