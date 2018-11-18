package com.c9ea90.dbwrapper

/**
 * Created by 09ae9c on 18-11-18.
 */
interface IQuery {

    fun equalsTo(key:String,value:String):IQuery

    fun findFirst():IModel?

}