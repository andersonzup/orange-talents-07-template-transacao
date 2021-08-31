package br.com.zup.transacoes.compras;

import br.com.zup.transacoes.exception.CardNotFoundException;
import br.com.zup.transacoes.consumer.entity.Transacao;
import br.com.zup.transacoes.consumer.entity.TransacaoRepository;

import br.com.zup.transacoes.utils.Util;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Slice;

import org.springframework.data.web.PageableDefault;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.stream.Collectors;


import static org.springframework.data.domain.Sort.Direction.*;

@RestController
@RequestMapping(path = "/api/v1/compra")
public class ComprasController {

    private TransacaoRepository transacaoRepository;

    public ComprasController(TransacaoRepository transacaoRepository) {
        this.transacaoRepository = transacaoRepository;
    }

    @GetMapping(path = "/{id}")
    public List<CompraResponse> listarCompras(@PathVariable("id") String id, @PageableDefault(size = 10, sort = "id", direction = DESC) Pageable pageable) throws CardNotFoundException {
        Util.validadorCartao(id, transacaoRepository);
        Slice<Transacao> slicedResult = transacaoRepository.findAllByCartao_Idcartao(id, pageable);
        List<CompraResponse> compras = compraResponseList(slicedResult.getContent());
        return compras;
    }

    private List<CompraResponse> compraResponseList(List<Transacao> transacoes) {
        List<CompraResponse> list = transacoes.stream().map(CompraResponse::new).collect(Collectors.toList());
        return list;
    }


}
