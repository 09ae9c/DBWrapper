package com.c9ea90.dbwrapper

/**
 * Created by 09ae9c on 18-11-18.
 */
interface IQuery {

    fun equalsTo(key: String, value: String): IQuery

    fun greaterThan(key: String, value: Int): IQuery
    fun greaterThan(key: String, value: Long): IQuery
    fun greaterThan(key: String, value: Double): IQuery

    fun greaterThanOrEqualTo(key: String, value: Int): IQuery
    fun greaterThanOrEqualTo(key: String, value: Long): IQuery
    fun greaterThanOrEqualTo(key: String, value: Double): IQuery

    fun lessThan(key: String, value: Int): IQuery
    fun lessThan(key: String, value: Long): IQuery
    fun lessThan(key: String, value: Double): IQuery

    fun lessThanOrEqualTo(key: String, value: Int): IQuery
    fun lessThanOrEqualTo(key: String, value: Long): IQuery
    fun lessThanOrEqualTo(key: String, value: Double): IQuery

    fun sort(key: String, sort: SortOrder): IQuery

    fun findFirst(): IModel?

    fun findALl(): List<IModel>
}