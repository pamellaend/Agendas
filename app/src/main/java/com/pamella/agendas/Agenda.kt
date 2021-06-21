package com.pamella.agendas

import android.os.Parcel
import android.os.Parcelable


 var contacts: MutableList<String> = mutableListOf()

open class Agenda() : Parcelable {


    open fun addContact(name: String, phone: String, relation: String): String {
        var showItem = ""
        contacts.add("$name - $phone \n $relation")
        contacts.sort()
        for (i in contacts) {
            showItem += "$i \n________\n"
        }
        return showItem
    }

    open fun listFinal(): String {
        var showItem = ""
        contacts.sort()
        for (i in contacts) {
            showItem += "$i \n_________\n"
        }
        return showItem
    }

    fun consultList(N: String): String {
        var exibir = ""
        contacts.sort()
        for (y in contacts) {
            val nome = y.split(" ")
            for (i in nome.indices) {
                if (nome[i] == N) {
                    exibir += y + "\n"
                }
            }
        }
        return exibir
    }
}