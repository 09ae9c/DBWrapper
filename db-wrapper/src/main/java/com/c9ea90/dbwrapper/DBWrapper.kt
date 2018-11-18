package com.c9ea90.dbwrapper

import android.util.Log

/**
 * Created by 09ae9c on 18-11-18.
 */
class DBWrapper private constructor(config: DBWrapperConfig) {

    companion object {

        private const val TAG = "DBWrapper"

        @Volatile
        var INSTANCE: DBWrapper? = null

        fun initialize(config: DBWrapperConfig) {
            if (INSTANCE != null) {
                Log.d(TAG, "DBWrapper have already been init")
            } else {
                INSTANCE = DBWrapper(config)
            }
        }

        fun get(): DBWrapper {
            return INSTANCE ?: throw RuntimeException("you must call initialize() before get()")
        }
    }

    private val adapter = config.adapter

    init {
        val appCtx = config.context.applicationContext


        adapter.initialize(appCtx)

        Log.d(TAG, "DBWrapper init done!")
    }

    fun getDBHandler(): IDBHandler {
        return adapter.getDBHandler()
    }

    fun <E : IModel> getDBQuery(handler: IDBHandler, cls: Class<E>): IQuery {
        return adapter.getDBQuery(handler, cls)
    }
}