package com.c9ea90.dbadapter.realm

import com.c9ea90.dbwrapper.IModel
import com.c9ea90.dbwrapper.IQuery
import com.c9ea90.dbwrapper.SortOrder
import io.realm.Sort
import io.realm.kotlin.deleteFromRealm

/**
 * Created by 09ae9c on 18-11-18.
 */
class DbRealmQuery(private val realmHandler: DbRealmHandler, cls: Class<IRealmModel>) : IQuery {
    private val query = realmHandler.realm.where(cls)

    override fun equalsTo(key: String, value: String): IQuery {
        query.equalTo(key, value)
        return this
    }

    override fun greaterThan(key: String, value: Int): IQuery {
        query.greaterThan(key, value)
        return this
    }

    override fun greaterThan(key: String, value: Long): IQuery {
        query.greaterThan(key, value)
        return this
    }

    override fun greaterThan(key: String, value: Double): IQuery {
        query.greaterThan(key, value)
        return this
    }

    override fun greaterThanOrEqualTo(key: String, value: Int): IQuery {
        query.greaterThanOrEqualTo(key, value)
        return this
    }

    override fun greaterThanOrEqualTo(key: String, value: Long): IQuery {
        query.greaterThanOrEqualTo(key, value)
        return this
    }

    override fun greaterThanOrEqualTo(key: String, value: Double): IQuery {
        query.greaterThanOrEqualTo(key, value)
        return this
    }

    override fun lessThan(key: String, value: Int): IQuery {
        query.lessThan(key, value)
        return this
    }

    override fun lessThan(key: String, value: Long): IQuery {
        query.lessThan(key, value)
        return this
    }

    override fun lessThan(key: String, value: Double): IQuery {
        query.lessThan(key, value)
        return this
    }

    override fun lessThanOrEqualTo(key: String, value: Int): IQuery {
        query.lessThanOrEqualTo(key, value)
        return this
    }

    override fun lessThanOrEqualTo(key: String, value: Long): IQuery {
        query.lessThanOrEqualTo(key, value)
        return this
    }

    override fun lessThanOrEqualTo(key: String, value: Double): IQuery {
        query.lessThanOrEqualTo(key, value)
        return this
    }

    override fun sort(key: String, sort: SortOrder): IQuery {
        val realmSort = if (sort == SortOrder.ASCENDING) Sort.ASCENDING else Sort.DESCENDING
        query.sort(key, realmSort)
        return this
    }

    override fun findFirst(): IModel? {
        return query.findFirst()
    }

    override fun findAll(): List<IModel> {
        return query.findAll()
    }

    override fun deleteFirst(): Boolean {
        realmHandler.realm.safeExecTransaction {
            query.findFirst()?.deleteFromRealm()
        }
        return true
    }

    override fun deleteAll(): Boolean {
        realmHandler.realm.safeExecTransaction {
            query.findAll()?.deleteAllFromRealm()
        }
        return true
    }
}