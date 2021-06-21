package com.pamella.agendas

import android.content.Context
import android.service.autofill.Dataset
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView


class ContatosAdapter(val context: Context, var dataSet : MutableList<String>) :RecyclerView.Adapter<ContatosAdapter.ContatosViewHolder>() {

    class ContatosViewHolder(view:View):RecyclerView.ViewHolder(view) {
        val contato = view.findViewById<TextView>(R.id.itemNome)
    }



    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ContatosViewHolder {
        val instanciaView = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_contato, parent, false)
        return ContatosViewHolder(instanciaView)
    }

    override fun onBindViewHolder(holder:ContatosViewHolder, position: Int) {
        holder.contato.text = dataSet[position]
        holder.itemView.buttonDelete.setOnClickListener {
            contacts.removeAt(position)
            notifyItemRemoved(position)
            notifyDataSetChanged()
        }
    }

    override fun getItemCount(): Int  = dataSet.size
        fun atualizarLista(listaFiltrada: MutableList<String>){
            dataSet = listaFiltrada
            notifyDataSetChanged()
        }
}