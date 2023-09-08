package com.m68476521.comicos.di.component

import android.app.Application
import com.m68476521.comicos.base.BaseApplication
import com.m68476521.comicos.di.module.ActivityBindingModule
import com.m68476521.comicos.di.module.ContextModule
import dagger.BindsInstance
import dagger.Component
import dagger.android.AndroidInjectionModule
import dagger.android.support.AndroidSupportInjectionModule
import javax.inject.Singleton

@Singleton

//@Component(
//    modules = arrayOf(AndroidInjectionModule::class, ApplicationModule::class, AppModule::class)
//)
//@Component(modules = { ContextModule.class, ApplicationModule.class, AndroidSupportInjectionModule.class, ActivityBindingModule.class})

@Component(
    modules = arrayOf(ContextModule::class, ApplicationModule::class, AndroidSupportInjectionModule::class, ActivityBindingModule::class)
)
interface ApplicationComponent {
    fun inject(application: BaseApplication?)

    @Component.Builder
    interface Builder {
        @BindsInstance
        fun application(application: Application?): Builder?
        fun build(): ApplicationComponent?
    }
}