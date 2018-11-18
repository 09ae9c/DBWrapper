package com.c9ea90.dbwrapper

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import com.c9ea90.dbadapter.realm.RealmQueryWrapper
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
            })
        }

        dbHandler.create(list)
    }

    fun onQueryUserById(view: View) {
        val query = DBWrapper.get().getDBQuery(dbHandler, User::class.java)

        val user = query.equalsTo("id", "001")
            .findFirst()

        Toast.makeText(this, "find user is: $user", Toast.LENGTH_SHORT).show()
    }

    fun onQueryUserListByType(view: View) {

    }
}
