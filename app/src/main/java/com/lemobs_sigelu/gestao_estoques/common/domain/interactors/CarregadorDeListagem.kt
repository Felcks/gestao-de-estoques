package com.lemobs_sigelu.gestao_estoques.common.domain.interactors

import com.lemobs_sigelu.gestao_estoques.common.domain.model.Material
import io.reactivex.Observable

interface CarregadorDeListagem<T> {

    fun executa(): Observable<List<T>>
}