package com.c9ea90.dbwrapper

import android.app.Application
import com.c9ea90.dbadapter.realm.DbRealmAdapter

/**
 * Created by 09ae9c on 18-11-18.
 */
class BaseApp : Application() {

    override fun onCreate() {
        super.onCreate()

        DbWrapper.initialize(
            DbWrapperConfig.Builder(this)
                .adapter(DbRealmAdapter.create())
                .build()
        )
    }
}