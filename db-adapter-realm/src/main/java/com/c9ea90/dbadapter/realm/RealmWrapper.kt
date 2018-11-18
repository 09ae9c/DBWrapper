package com.c9ea90.dbadapter.realm

import com.c9ea90.dbwrapper.IDBHandler
import com.c9ea90.dbwrapper.IModel
import com.c9ea90.dbwrapper.IQuery
import io.realm.Realm
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
    override fun create(models: List<IModel>) {
        val realmModels = models as? List<IRealmModel>
            ?: throw RuntimeException(cannotCastError)
        realm.executeTransaction { it.copyToRealm(realmModels) }
    }

    override fun update(model: IModel) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun update(models: List<IModel>) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun query(query: IQuery) {

        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }
}