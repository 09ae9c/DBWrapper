package com.c9ea90.dbwrapper.model

import com.c9ea90.dbadapter.realm.IRealmModel
import io.realm.annotations.RealmClass

/**
 * Created by 09ae9c on 18-11-18.
 */
@RealmClass
open class User : IRealmModel {
    var id: String? = null
    var name: String? = null
    var type: String? = null

    var createdTs: Long = 0
}