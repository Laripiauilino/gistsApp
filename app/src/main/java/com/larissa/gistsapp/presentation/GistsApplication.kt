package com.larissa.gistsapp.presentation

import android.app.Application
import com.larissa.gistsapp.data.db.base.DatabaseBuilder

class GistsApplication : Application() {

    override fun onCreate() {
        super.onCreate()

        DatabaseBuilder.getFavoriteDatabase(this)
    }
}