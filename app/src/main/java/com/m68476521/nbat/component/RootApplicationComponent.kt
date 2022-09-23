package com.m68476521.nbat.component

import com.m68476521.nbat.home.HomeFragment
import com.m68476521.nbat.model.MyModel

interface RootApplicationComponent {
    fun inject(myModel: MyModel)
    fun inject(homeFragment: HomeFragment)
    fun inject(myApplication: MyApplication)
}