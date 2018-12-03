package com.c9ea90.dbadapter.realm

import android.content.Context
import com.c9ea90.dbwrapper.IDbAdapter
import com.c9ea90.dbwrapper.IDbHandler
import io.realm.Realm
import io.realm.RealmConfiguration

/**
 * Created by 09ae9c on 18-11-18.
 */
class DbRealmAdapter private constructor() : IDbAdapter {

    companion object {
        fun create(): DbRealmAdapter {
            return DbRealmAdapter()
        }
    }

    override fun initialize(context: Context) {
        Realm.init(context)
    }

    override fun getDbHandler(): IDbHandler {
        val config = RealmConfiguration.Builder()
            .deleteRealmIfMigrationNeeded()
            .build()
        return DbRealmHandler(Realm.getInstance(config))
    }
}