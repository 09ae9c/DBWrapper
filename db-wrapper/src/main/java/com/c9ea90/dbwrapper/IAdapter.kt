package com.c9ea90.dbwrapper

import android.content.Context

/**
 * Created by 09ae9c on 18-11-18.
 */
interface IAdapter {

    fun initialize(context: Context)

    fun getDBHandler(): IDBHandler
}