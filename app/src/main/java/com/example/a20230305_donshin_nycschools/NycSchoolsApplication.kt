package com.example.a20230305_donshin_nycschools

import android.app.Application
import com.example.a20230305_donshin_nycschools.dataManager.AppContainer
import com.example.a20230305_donshin_nycschools.dataManager.DefaultAppContainer

class NycSchoolsApplication : Application() {
    lateinit var container: com.example.a20230305_donshin_nycschools.dataManager.AppContainer

    override fun onCreate() {
        super.onCreate()
        container = com.example.a20230305_donshin_nycschools.dataManager.DefaultAppContainer()
    }
}