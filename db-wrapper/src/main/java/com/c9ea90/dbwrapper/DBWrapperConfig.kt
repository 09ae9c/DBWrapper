package com.c9ea90.dbwrapper

import android.content.Context
import android.util.Log

/**
 * Created by 09ae9c on 18-11-18.
 */
class DBWrapperConfig private constructor(val context: Context, val adapter: IAdapter) {

    class Builder(private val context: Context) {
        private var mAdapter: IAdapter? = null

        fun adapter(adapter: IAdapter): Builder {
            this.mAdapter = adapter
            return this
        }

        fun build(): DBWrapperConfig {

            val adapter = checkNotNull(mAdapter) { Log.e("DBWrapper", "you must provider a Adapter") }
            return DBWrapperConfig(context, adapter)
        }
    }
}