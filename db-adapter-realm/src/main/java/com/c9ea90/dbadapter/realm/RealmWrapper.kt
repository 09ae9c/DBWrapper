package com.c9ea90.dbadapter.realm

import com.c9ea90.dbwrapper.IDBHandler
import com.c9ea90.dbwrapper.IModel
import com.c9ea90.dbwrapper.IQuery
import io.realm.Realm
import io.realm.RealmModel
import io.realm.RealmQuery

/**
 * Created by 09ae9c on 18-11-18.
 */
class RealmWrapper(val realm: Realm) : IDBHandler {


    companion object {
        private const val cannotCastError =
            "cannot cast IModel to RealmModel, please make sure your model is implement IRealmModel"
    }

    override fun create(model: IModel) {
        if (model is IRealmModel) {
            realm.executeTransaction { it.copyToRealm(model) }
        } else {
            throw RuntimeException(cannotCastError)
        }
    }

    @Suppress("UNCHECKED_CAST")
    override fun createAll(models: List<IModel>) {
        val realmModels = models as? List<IRealmModel>
            ?: throw RuntimeException(cannotCastError)
        realm.executeTransaction { it.copyToRealm(realmModels) }
    }

    override fun update(model: IModel) {
        if (model is IRealmModel) {
            realm.executeTransaction { it.copyToRealmOrUpdate(model) }
        } else {
            throw RuntimeException(cannotCastError)
        }
    }

    @Suppress("UNCHECKED_CAST")
    override fun updateAll(models: List<IModel>) {
        val realmModels = models as? List<IRealmModel>
            ?: throw RuntimeException(cannotCastError)
        realm.executeTransaction { it.copyToRealmOrUpdate(realmModels) }
    }

    @Suppress("UNCHECKED_CAST")
    override fun <C : IModel> query(cls: Class<C>): IQuery {
        return RealmQueryWrapper(this, cls as Class<IRealmModel>)
    }

    private fun checkType(model: IModel) {
        if (model !is IRealmModel) throw RuntimeException(cannotCastError)
    }
}