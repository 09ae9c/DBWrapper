package com.c9ea90.dbwrapper

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.util.Log
import android.view.View
import android.widget.Toast
import com.c9ea90.dbwrapper.model.User

class MainActivity : AppCompatActivity() {

    private lateinit var dbHandler: IDBHandler

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        dbHandler = DBWrapper.get().getDBHandler()
    }

    fun onCreateUser(view: View) {
        val user = User().apply {
            id = "001"
            name = "first"
            type = "normal"
            createdTs = System.currentTimeMillis()
        }
        dbHandler.create(user)
    }

    fun onCreateUserList(view: View) {
        val list = arrayListOf<User>()
        for (i in 0..9) {
            list.add(User().apply {
                id = "$i-list"
                name = "name-$i"
                type = if (i % 2 == 0) "normal" else "robot"
                createdTs = System.currentTimeMillis()
            })
        }
        dbHandler.createAll(list)
    }

    fun onQueryUserById(view: View) {
        val user = dbHandler.query(User::class.java).equalsTo("id", "001")
            .findFirst()

        toastAndLog("find user: $user")
    }

    fun onQueryUserListByType(view: View) {
        val result = dbHandler.query(User::class.java)
            .findAll()

        toastAndLog("find users: $result")
    }

    fun onQueryUserWithCondition(view: View) {
        val result = dbHandler.query(User::class.java)
            .equalsTo("type", "robot")
            .sort("createdTs", SortOrder.DESCENDING)
            .findAll()

        toastAndLog("find users: $result")
    }

    fun onDeleteFirstFromQueryAllUsers(view: View) {
        dbHandler.query(User::class.java)
            .deleteAll()
    }

    private fun toastAndLog(content: String) {
        Log.i("MainActivity", content)
        Toast.makeText(this, content, Toast.LENGTH_SHORT).show()
    }
}

