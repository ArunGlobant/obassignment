package com.obassignment

import android.app.Application
import com.obassignment.data.network.di.dataAppModule
import com.obassignment.data.network.di.dataInterModule
import com.obassignment.domain.model.di.domainAppModule
import com.obassignment.presentation.di.viewModelMoudle
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

class BaseApplication: Application() {

    override fun onCreate() {
        super.onCreate()
        startKoin {
            modules(
                viewModelMoudle, dataAppModule, dataInterModule, domainAppModule
            )
            androidContext(this@BaseApplication)
        }
    }
}