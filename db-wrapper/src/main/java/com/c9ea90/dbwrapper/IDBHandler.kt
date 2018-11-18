package com.c9ea90.dbwrapper

/**
 * Created by 09ae9c on 18-11-18.
 */
interface IDBHandler {

    fun create(model:IModel)
    fun create(models:List<IModel>)

    fun update(model:IModel)
    fun update(models:List<IModel>)

    fun query(query:IQuery)
}