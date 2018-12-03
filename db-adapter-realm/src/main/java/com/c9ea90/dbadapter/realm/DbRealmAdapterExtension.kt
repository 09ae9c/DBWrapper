package com.c9ea90.dbadapter.realm

import io.realm.Realm

/**
 * Created by tancen on 2018/12/3.
 */


/**
 *  Execute a transaction safely
 */
inline fun Realm.safeExecTransaction(crossinline block: (Realm) -> Unit) {
    if (isInTransaction) {
        block(this)
    } else {
        executeTransaction {
            block(this)
        }
    }
}

/**
 *  Execute a transaction safely, and return the result
 */
inline fun <T> Realm.safeWithTransaction(crossinline block: (Realm) -> T?): T? {
    return if (isInTransaction) {
        block(this)
    } else {
        var result: T? = null
        executeTransaction {
            result = block(this)
        }
        result
    }
}
