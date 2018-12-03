package com.c9ea90.dbwrapper

import android.util.Log

/**
 * Created by 09ae9c on 18-11-18.
 */
class DbWrapper private constructor(config: DbWrapperConfig) {

    companion object {

        private const val TAG = "DbWrapper"

        @Volatile
        var INSTANCE: DbWrapper? = null

        fun initialize(config: DbWrapperConfig) {
            if (INSTANCE != null) {
                Log.d(TAG, "DbWrapper have already been init")
            } else {
                INSTANCE = DbWrapper(config)
            }
        }

        fun get(): DbWrapper {
            return INSTANCE ?: throw RuntimeException("you must call initialize() before get()")
        }
    }

    private val adapter = config.adapter

    init {
        val appCtx = config.context.applicationContext

        adapter.initialize(appCtx)

        Log.d(TAG, "DbWrapper init done!")
    }

    fun getDBHandler(): IDbHandler {
        return adapter.getDbHandler()
    }
}