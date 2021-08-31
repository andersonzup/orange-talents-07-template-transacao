package br.com.zup.transacoes.utils;

import br.com.zup.transacoes.consumer.entity.TransacaoRepository;
import br.com.zup.transacoes.exception.CardNotFoundException;

public class Util {

    public static void validadorCartao(String id, TransacaoRepository transacaoRepository) throws CardNotFoundException{
        if (!transacaoRepository.existsByCartao_Idcartao(id)) {
            throw new CardNotFoundException();
        }

    }
}
