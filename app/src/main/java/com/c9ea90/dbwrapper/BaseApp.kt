package com.c9ea90.dbwrapper

import android.app.Application
import com.c9ea90.dbadapter.realm.DBAdapterRealm

/**
 * Created by 09ae9c on 18-11-18.
 */
class BaseApp : Application() {

    override fun onCreate() {
        super.onCreate()

        DBWrapper.initialize(
            DBWrapperConfig.Builder(this)
                .adapter(DBAdapterRealm.create())
                .build()
        )
    }
}