package com.mediconear.di

import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.FragmentManager
import com.mediconear.navigation.Router
import com.mediconear.navigation.RouterImpl
import org.koin.core.module.Module
import org.koin.dsl.module

fun appModule(): Module = module {

    factory<Router> {
        val activity: AppCompatActivity = it[0]
        val fragmentManager: FragmentManager = activity.supportFragmentManager
        RouterImpl(activity, fragmentManager, get())
    }
}
