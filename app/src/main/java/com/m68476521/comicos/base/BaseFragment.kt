package com.m68476521.comicos.base

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.annotation.LayoutRes
import androidx.annotation.NonNull
import androidx.appcompat.app.AppCompatActivity
import butterknife.ButterKnife
import butterknife.Unbinder
import dagger.android.support.DaggerFragment

//import dagger.android.support.DaggerFragment


abstract class BaseFragment : DaggerFragment() {
    private var unbinder: Unbinder? = null
    var baseActivity: AppCompatActivity? = null
        private set

    @LayoutRes
    protected abstract fun layoutRes(): Int
    override fun onCreateView(
        @NonNull inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val view: View = inflater.inflate(layoutRes(), container, false)
        unbinder = ButterKnife.bind(this, view)
        return view
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)
        baseActivity = context
    }

//    fun onAttach(context: Context?) {
//        super.onAttach(context)
//        baseActivity = context
//    }

    override fun onDetach() {
        super.onDetach()
        baseActivity = null
    }

    override fun onDestroyView() {
        super.onDestroyView()
        if (unbinder != null) {
            unbinder!!.unbind()
            unbinder = null
        }
    }
}