package com.lemobs_sigelu.gestao_estoques.common.domain.interactors

import android.content.Context
import com.lemobs_sigelu.gestao_estoques.common.domain.model.MaterialDePedido
import com.lemobs_sigelu.gestao_estoques.common.domain.model.Pedido
import com.lemobs_sigelu.gestao_estoques.common.domain.model.SituacaoHistorico
import com.lemobs_sigelu.gestao_estoques.common.domain.repository.CarregaListaMaterialDoPedidoRepository
import com.lemobs_sigelu.gestao_estoques.common.domain.repository.CarregaListaSituacaoDoPedidoRepository
import com.lemobs_sigelu.gestao_estoques.common.domain.repository.VisualizaPedidoRepository
import io.reactivex.Observable
import javax.inject.Inject

class VisualizaPedidoUseCase @Inject constructor(val visualizarRepository: VisualizaPedidoRepository,
                                                 val carregaListaMaterialPedidoRepository: CarregaListaMaterialDoPedidoRepository,
                                                 val carregaListasituacaoRespository: CarregaListaSituacaoDoPedidoRepository) {

    fun getPedido(context: Context): Observable<Pedido> {
        return visualizarRepository.getPedido(context)
    }

    fun getTituloPedido(context: Context) = visualizarRepository.getTituloDePedido(context)

    fun getSituacaoPedido(context: Context) = visualizarRepository.getSituacaoPedido(context)

    fun getSituacoesDoPedido(context: Context): Observable<List<SituacaoHistorico>> {
        return carregaListasituacaoRespository.getSituacoesDePedido(context)
    }

    fun getMateriaisDePedido(context: Context): Observable<List<MaterialDePedido>> {
        return carregaListaMaterialPedidoRepository.getMateriaisDePedido(context)
    }
}