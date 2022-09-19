package com.m68476521.nbat.component

import android.app.Application
import com.m68476521.nbat.MainActivity
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(modules = [ApiModule::class])
interface ApplicationComponent {
    fun inject(mainActivity: MainActivity)
}

// appComponent lives in the Application class to share its lifecycle
class MyApplication : Application() {
    // Reference to the application graph that is used across the whole app
    val appComponent = DaggerApplicationComponent.create()
}
