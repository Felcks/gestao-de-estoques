package com.lemobs_sigelu.gestao_estoques.ui.seleciona_materiais_pedido

import com.lemobs_sigelu.gestao_estoques.common.domain.interactors.SelecionaMaterialPedidoUseCase
import com.lemobs_sigelu.gestao_estoques.common.domain.repository.CarregaListaMaterialParaCadastroRepository
import com.lemobs_sigelu.gestao_estoques.common.domain.repository.SelecionaMaterialParaPedidoRepository
import dagger.Module
import dagger.Provides

@Module
class SelecionaMaterialPedidoModule {

    @Provides
    fun provideListaMaterial(): CarregaListaMaterialParaCadastroRepository {
        return CarregaListaMaterialParaCadastroRepository()
    }

    @Provides
    fun provideSelecionaMaterial(): SelecionaMaterialParaPedidoRepository {
        return SelecionaMaterialParaPedidoRepository()
    }

    @Provides
    fun provideViewModelFactory(selecionaMaterialPedidoUseCase: SelecionaMaterialPedidoUseCase): SelecionaMaterialPedidoViewModelFactory {
        return SelecionaMaterialPedidoViewModelFactory(selecionaMaterialPedidoUseCase)
    }

}