package com.lemobs_sigelu.gestao_estoques.api_model

class MaterialDataResponse (val id: Int,
                            val nome: String?,
                            val preco: Double?,
                            val contratado: Double?,
                            val saldo: Double?,
                            val disponivel: Double?,
                            val unidade_medida: UnidadeMedidaDataResponse?,
                            val disponibilidade_nucleos: List<NucleoDisponibilidadeDataResponse>){
}