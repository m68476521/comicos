package com.m68476521.nbat

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.lifecycleScope
import com.m68476521.nbat.component.MyApplication
import com.m68476521.nbat.repository.ApiRepository
import kotlinx.coroutines.launch
import javax.inject.Inject

class MainActivity : AppCompatActivity() {
    @Inject
    lateinit var apiRepository: ApiRepository

    override fun onCreate(savedInstanceState: Bundle?) {
        (applicationContext as MyApplication).appComponent.inject(this)
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        //TODO This is just for testing purposes
        lifecycleScope.launch {
            val response = apiRepository.getSessions()
            println("MIKE response ${response.data}")
            println("MIKE response ${response.data.size}")
        }
    }
}