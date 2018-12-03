package com.c9ea90.dbwrapper

/**
 * Created by 09ae9c on 18-11-18.
 */
interface IDbHandler {

    fun create(model: IModel)
    fun createAll(models: List<IModel>)

    fun update(model: IModel)
    fun updateAll(models: List<IModel>)

    fun <C : IModel> query(cls: Class<C>): IQuery
}