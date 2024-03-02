package com.m68476521.nbat.component

import android.app.Application
import dagger.hilt.android.HiltAndroidApp

interface ApplicationComponent: RootApplicationComponent

@HiltAndroidApp
class MyApplication : Application()
