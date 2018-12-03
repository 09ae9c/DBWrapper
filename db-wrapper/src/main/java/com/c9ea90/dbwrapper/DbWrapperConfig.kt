package com.c9ea90.dbwrapper

import android.content.Context
import android.util.Log

/**
 * Created by 09ae9c on 18-11-18.
 */
class DbWrapperConfig private constructor(val context: Context, val adapter: IDbAdapter) {

    class Builder(private val context: Context) {
        private var mAdapter: IDbAdapter? = null

        fun adapter(adapter: IDbAdapter): Builder {
            this.mAdapter = adapter
            return this
        }

        fun build(): DbWrapperConfig {
            val adapter = checkNotNull(mAdapter) { Log.e("DbWrapper", "you must provider a Adapter") }
            return DbWrapperConfig(context, adapter)
        }
    }
}