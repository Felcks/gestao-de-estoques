package com.lemobs_sigelu.gestao_estoques.common.domain.interactors

import android.content.Context
import com.lemobs_sigelu.gestao_estoques.common.domain.model.MaterialDePedido
import com.lemobs_sigelu.gestao_estoques.common.domain.repository.CarregaListaMaterialDoPedidoRepository
import com.lemobs_sigelu.gestao_estoques.common.domain.repository.EntregaMaterialDoPedidoRepository
import com.lemobs_sigelu.gestao_estoques.common.domain.repository.VisualizaPedidoRepository
import io.reactivex.Observable
import javax.inject.Inject

class EntregaMaterialUseCase @Inject constructor(val carregaListaMaterialPedidoRepository: CarregaListaMaterialDoPedidoRepository,
                                                 val visualizarPedidoRepository: VisualizaPedidoRepository,
                                                 val fluxoEntregaMaterialPedidoRepository: EntregaMaterialDoPedidoRepository) {

    fun getListaMaterialPedido(context: Context): Observable<List<MaterialDePedido>> {
        return carregaListaMaterialPedidoRepository.getMateriaisDePedido(context)
    }

    fun getTituloPedido(context: Context) = visualizarPedidoRepository.getTituloDePedido(context)

    fun enviarEntregaDeMateriais(context: Context, list: List<MaterialDePedido>): Observable<Boolean>{
        return fluxoEntregaMaterialPedidoRepository.enviarEntregaDeMateriais(context, list)
    }

}