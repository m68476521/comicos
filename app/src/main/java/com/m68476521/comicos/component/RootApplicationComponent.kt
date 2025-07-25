package com.m68476521.comicos.component

import com.m68476521.comicos.home.HomeFragment
import com.m68476521.comicos.model.MyModel

interface RootApplicationComponent {
    fun inject(myModel: MyModel)

    fun inject(homeFragment: HomeFragment)
}
