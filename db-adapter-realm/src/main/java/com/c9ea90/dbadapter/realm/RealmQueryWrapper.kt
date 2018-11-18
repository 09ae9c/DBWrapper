package com.c9ea90.dbadapter.realm

import com.c9ea90.dbwrapper.IModel
import com.c9ea90.dbwrapper.IQuery

/**
 * Created by 09ae9c on 18-11-18.
 */
class RealmQueryWrapper(realmWrapper: RealmWrapper, cls: Class<*>) : IQuery {
   private val query = realmWrapper.realm.where((cls as IRealmModel).javaClass)


    override fun equalsTo(key: String, value: String): IQuery {
        query.equalTo(key, value)
        return this
    }

    override fun findFirst(): IModel? {
        return query.findFirst()
    }
}