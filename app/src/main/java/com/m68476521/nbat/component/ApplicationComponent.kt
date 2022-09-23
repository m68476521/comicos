package com.m68476521.nbat.component

import android.app.Application
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(modules = [ApiModule::class])
interface ApplicationComponent: RootApplicationComponent

class MyApplication : Application() , HasComponent<ApplicationComponent>{

    @OptIn(ExperimentalStdlibApi::class)
    private val applicationComponent: Lazy<ApplicationComponent> = lazy {
        DaggerApplicationComponent.builder()
            .apiModule(apiModule).build()
    }
    override val component: ApplicationComponent
        get() = applicationComponent.value

    override fun onCreate() {
        super.onCreate()

        component.inject(this)
    }
}
