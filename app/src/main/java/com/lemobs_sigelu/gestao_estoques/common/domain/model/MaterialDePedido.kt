package com.lemobs_sigelu.gestao_estoques.common.domain.model

import com.lemobs_sigelu.gestao_estoques.bd_model.MaterialDTO
import com.lemobs_sigelu.gestao_estoques.bd_model.MaterialDePedidoDTO
import com.lemobs_sigelu.gestao_estoques.bd_model.PedidoDTO
import com.lemobs_sigelu.gestao_estoques.bd_model.UnidadeMedidaDTO

class MaterialDePedido (val id: Int,
                        val nome: String,
                        val descricao: String,
                        val contratado: Double,
                        var recebido: Double,
                        val unidadeMedida: UnidadeMedida){

    var entregue: Double = 0.0

    fun getEquivalentDTO(pedidoDTO: PedidoDTO, materialbaseId: Int): MaterialDePedidoDTO {
        return MaterialDePedidoDTO(id,
            MaterialDTO(materialbaseId, nome, descricao, unidadeMedida.getEquivalentDTO()),
            contratado,
            recebido,
            pedidoDTO)
    }
}