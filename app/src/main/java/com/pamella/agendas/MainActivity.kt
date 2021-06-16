package com.pamella.agendas

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.view.WindowManager
import android.widget.*
import android.widget.Toast.*
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    private lateinit var searchTxt: EditText
    private lateinit var searchButton: ImageButton
    private lateinit var showAllContactsButton: Button
    private lateinit var showContactsTxt: TextView
    private lateinit var registerButton: Button

//    fun startSecondActivity(view: View?) {
//        val secondActivity = Intent(this, Cadastro::class.java)
//        startActivity(secondActivity)
//    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        this.supportActionBar?.hide()

//        window.setFlags(
//            WindowManager.LayoutParams.FLAG_FULLSCREEN,
//            WindowManager.LayoutParams.FLAG_FULLSCREEN
//        )


        bindView()
        val contacts = Agenda()

        showContactsTxt.text = intent.getStringExtra("save")

        registerButton.setOnClickListener {
            val intent = Intent(this, Cadastro::class.java)
            startActivity(intent)
        }


        searchButton.setOnClickListener {
            val search = searchTxt.text.toString()
            if(search.isNotEmpty()){
                showContactsTxt.text = contacts.consultList(search)
                searchTxt.text.clear()
            }
            if(search.isEmpty()) searchTxt.error = getString(R.string.toast_pesquisa)
            else {
                makeText(this, getString(R.string.toast_naocadastrado), LENGTH_SHORT).show()
            }

        }


        showAllContactsButton.setOnClickListener()
        {
            showContactsTxt.text = contacts.listFinal()
        }
    }

    private fun bindView() {
        searchTxt = findViewById(R.id.pesquisar)
        searchButton = findViewById(R.id.imageButton)
        showAllContactsButton = findViewById(R.id.mostrarcontatosB)
        showContactsTxt = findViewById(R.id.contatostxt)
        registerButton = findViewById(R.id.cadastrarContatos)
    }

}