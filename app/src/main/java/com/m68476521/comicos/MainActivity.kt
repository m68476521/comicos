package com.m68476521.comicos

import ComicosApp
import ComicosTheme
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import dagger.hilt.android.AndroidEntryPoint
import timber.log.Timber

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        if (BuildConfig.DEBUG){
            Timber.plant(Timber.DebugTree())
        }

        setContent {
            ComicosTheme {
                ComicosApp()
            }
        }
    }
}
