package com.lemobs_sigelu.gestao_estoques.common.domain.repository

import com.lemobs_sigelu.gestao_estoques.MATERIAL_DE_PEDIDO_MOCKADOS
import com.lemobs_sigelu.gestao_estoques.common.domain.model.MaterialDePedido
import com.lemobs_sigelu.gestao_estoques.common.domain.model.Pedido
import com.lemobs_sigelu.gestao_estoques.common.domain.model.SituacaoDePedido
import com.lemobs_sigelu.gestao_estoques.pedido_1
import com.lemobs_sigelu.gestao_estoques.situacoes_de_pedido
import io.reactivex.Observable

class VisualizarPedidoRepository {

    fun getPedido(): Observable<Pedido> {

        return Observable.create { subscribe ->
            subscribe.onNext(pedido_1)
            subscribe.onComplete()
        }
    }

    fun getTituloDePedido(): String = pedido_1.getCodigoFormatado()

    fun getSituacoesDoPedido(): Observable<List<SituacaoDePedido>> {

        return Observable.create { subscribe ->
            subscribe.onNext(situacoes_de_pedido)
            subscribe.onComplete()
        }
    }

    fun getMateriaisDePedido(): Observable<List<MaterialDePedido>> {

        return Observable.create { subscribe ->
            subscribe.onNext(MATERIAL_DE_PEDIDO_MOCKADOS)
            subscribe.onComplete()
        }
    }
}