package com.c9ea90.dbadapter.realm

import com.c9ea90.dbwrapper.IDbHandler
import com.c9ea90.dbwrapper.IModel
import com.c9ea90.dbwrapper.IQuery
import io.realm.Realm

/**
 * Created by 09ae9c on 18-11-18.
 */
class DbRealmHandler(val realm: Realm) : IDbHandler {

    companion object {
        private const val cannotCastError =
            "cannot cast IModel to RealmModel, please make sure your model is implement IRealmModel"
    }

    override fun create(model: IModel) {
        if (model is IRealmModel) {
            realm.safeExecTransaction { it.copyToRealm(model) }
        } else {
            throw RuntimeException(cannotCastError)
        }
    }

    @Suppress("UNCHECKED_CAST")
    override fun createAll(models: List<IModel>) {
        val realmModels = models as? List<IRealmModel>
            ?: throw RuntimeException(cannotCastError)
        realm.safeExecTransaction { it.copyToRealm(realmModels) }
    }

    override fun update(model: IModel) {
        if (model is IRealmModel) {
            realm.safeExecTransaction { it.copyToRealmOrUpdate(model) }
        } else {
            throw RuntimeException(cannotCastError)
        }
    }

    @Suppress("UNCHECKED_CAST")
    override fun updateAll(models: List<IModel>) {
        val realmModels = models as? List<IRealmModel>
            ?: throw RuntimeException(cannotCastError)
        realm.safeExecTransaction { it.copyToRealmOrUpdate(realmModels) }
    }

    @Suppress("UNCHECKED_CAST")
    override fun <C : IModel> query(cls: Class<C>): IQuery {
        return DbRealmQuery(this, cls as Class<IRealmModel>)
    }
}