package com.c9ea90.dbadapter.realm

import android.content.Context
import com.c9ea90.dbwrapper.IAdapter
import com.c9ea90.dbwrapper.IDBHandler
import com.c9ea90.dbwrapper.IModel
import com.c9ea90.dbwrapper.IQuery
import io.realm.Realm
import io.realm.RealmConfiguration

/**
 * Created by 09ae9c on 18-11-18.
 */
class DBAdapterRealm private constructor() : IAdapter {

    companion object {
        fun create(): DBAdapterRealm {
            return DBAdapterRealm()
        }
    }

    override fun initialize(context: Context) {
        Realm.init(context)
    }

    override fun getDBHandler(): IDBHandler {
        val config = RealmConfiguration.Builder()
            .deleteRealmIfMigrationNeeded()
            .build()
        return RealmWrapper(Realm.getInstance(config))
    }

    @Suppress("UNCHECKED_CAST")
    override fun <E : IModel> getDBQuery(handler: IDBHandler, cls: Class<E>): IQuery {
        if (handler is RealmWrapper) {
            return RealmQueryWrapper(handler, cls as Class<IRealmModel>)
        } else {
            throw RuntimeException("you must provider a RealmWrapper")
        }
    }
}