package com.c9ea90.dbwrapper

import android.content.Context

/**
 * Created by 09ae9c on 18-11-18.
 */
interface IDbAdapter {

    fun initialize(context: Context)

    fun getDbHandler(): IDbHandler
}