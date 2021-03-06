package com.lemobs_sigelu.gestao_estoques.ui.lista_materiais

import android.content.Context
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.lemobs_sigelu.gestao_estoques.R
import com.lemobs_sigelu.gestao_estoques.common.domain.model.Material
import com.lemobs_sigelu.gestao_estoques.common.domain.model.NucleoComMaterial
import com.lemobs_sigelu.gestao_estoques.utils.changeVisibility
import kotlinx.android.synthetic.main.item_material.view.*

class ListaMaterialAdapter(val context: Context,
                           val list: List<Material>): RecyclerView.Adapter<ListaMaterialAdapter.MyViewHolder>() {

    val mLayoutInflater: LayoutInflater = context.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater

    override fun onCreateViewHolder(parent: ViewGroup, p1: Int): MyViewHolder {

        val view = mLayoutInflater.inflate(R.layout.item_material, parent, false)
        return MyViewHolder(view)
    }

    override fun getItemCount(): Int {
        return list.size
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {

        val material = this.list.get(position)

        holder.itemView.tv_nome.text = material.nome
        holder.itemView.tv_unidade_medida.text = material.unidadeMedida.sigla
        holder.itemView.tv_contratado.text = material.contratado.toString()
        holder.itemView.tv_saldo.text = material.saldo.toString()
        holder.itemView.tv_disponivel.text = material.disponivel.toString()

        holder.itemView.ll_disponibilidade_nucleos.setOnClickListener {
            holder.itemView.rv_disponibilidade_nucleos.changeVisibility()
            holder.itemView.iv_down_arrow.changeVisibility()
            holder.itemView.iv_up_arrow.changeVisibility()
        }

        this.iniciarRecyclerViewDisponibilidadeNucleos(holder, material.disponibilidadeNucleos)
    }

    private fun iniciarRecyclerViewDisponibilidadeNucleos(holder: MyViewHolder, list: List<NucleoComMaterial>){

        val layoutManager = LinearLayoutManager(context)
        layoutManager.orientation = LinearLayoutManager.VERTICAL
        holder.itemView.rv_disponibilidade_nucleos.layoutManager = layoutManager

        val adapter = ListaDisponibilidadeNucleosAdapter(context, list)
        holder.itemView.rv_disponibilidade_nucleos.adapter = adapter
    }


    inner class MyViewHolder(view: View) : RecyclerView.ViewHolder(view) {}
}