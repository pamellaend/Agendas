package com.pamella.agendas

import android.content.Intent
import android.os.Bundle
import android.text.InputType.TYPE_CLASS_TEXT
import android.text.InputType.TYPE_TEXT_VARIATION_WEB_EMAIL_ADDRESS
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.RadioButton
import android.widget.Toast.LENGTH_SHORT
import android.widget.Toast.makeText
import androidx.appcompat.app.AppCompatActivity
import com.pamella.agendas.MainActivity


class Cadastro :AppCompatActivity() {
    private lateinit var nameTxt: EditText
    private lateinit var celTxt: EditText
    private lateinit var saveButton: Button
    private lateinit var refTxt: EditText
   // private lateinit var showContactsTxt: ArrayList
    var lists = ArrayList<String>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_cadastro)


//        bindView()
//        val contacts = Agenda()
//
//        saveButton.setOnClickListener {
//            val name = nameTxt.text.toString()
//            val phone = celTxt.text.toString()
//            val ref = refTxt.text.toString()
//            if (name.isEmpty())  nameTxt.error=getString(R.string.error_nome)
//            if (phone.isEmpty())  celTxt.error=getString(R.string.error_telefone)
//
//
//            lists.add(contacts.addContact(name, phone, ref))
//            makeText(this, getString(R.string.toast_cadastrado), LENGTH_SHORT).show()
//
//            val intent = Intent(this, MainActivity::class.java)
//            intent.putExtra("save", contacts.listFinal())
//            startActivity(intent)
//
//            nameTxt.text.clear()
//            celTxt.text.clear()
//            refTxt.text.clear()
//
//        }


    }

    override fun onResume() {
        super.onResume()
        bindView()
        val contacts = Agenda()

        saveButton.setOnClickListener {
            val name = nameTxt.text.toString()
            val phone = celTxt.text.toString()
            val ref = refTxt.text.toString()
            if (name.isEmpty())  nameTxt.error=getString(R.string.error_nome)
            if (phone.isEmpty())  celTxt.error=getString(R.string.error_telefone)


            lists.add(contacts.addContact(name, phone, ref))
            makeText(this, getString(R.string.toast_cadastrado), LENGTH_SHORT).show()

            val intent = Intent(this, MainActivity::class.java)
            intent.putExtra("save", contacts.listFinal())
            startActivity(intent)

            nameTxt.text.clear()
            celTxt.text.clear()
            refTxt.text.clear()

        }


    }
    private fun bindView() {
        nameTxt = findViewById(R.id.nome)
        celTxt = findViewById(R.id.telefone)
        saveButton = findViewById(R.id.saveB)
        refTxt = findViewById(R.id.referencia)
      //  showContactsTxt = " "
    }
    fun onRadioButtonClicked(view: View){
        if (view is RadioButton) {

            val checked = view.isChecked

            when (view.id) {
                R.id.buttonPessoal ->
                    if (checked) {
                        refTxt.inputType = TYPE_CLASS_TEXT
                        refTxt.hint = getString(R.string.hint_referencia)
                    }
                R.id.buttonTrabalho -> {
                    if (checked) {
                        refTxt.inputType = TYPE_TEXT_VARIATION_WEB_EMAIL_ADDRESS
                        refTxt.hint = getString(R.string.hint_email)
                    }
                }

            }

        }
    }}

private fun <E> ArrayList<E>.add(element: String) {

}


