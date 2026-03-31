package com.marcuscorreia.meu_segundo_projeto;

import org.springframework.web.bind.annotation.*;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/produtos")
public class ProdutoController {

    private List<Produto> produtos = new ArrayList<>();

    public ProdutoController() {
        produtos.add(new Produto(1, "Mouse", 50.0));
        produtos.add(new Produto(2, "Teclado", 120.0));
    }

    // GET
    @GetMapping
    public List<Produto> listar() {
        return produtos;
    }

    // POST
    @PostMapping
    public Produto adicionar(@RequestBody Produto produto) {
        int novoId = produtos.size() > 0 ?
                produtos.get(produtos.size() - 1).getId() + 1 : 1;

        produto.setId(novoId);
        produtos.add(produto);

        return produto;
    }

    // PUT
    @PutMapping("/{id}")
    public String atualizar(@PathVariable Integer id, @RequestBody Produto novoProduto) {

        for (int i = 0; i < produtos.size(); i++) {
            if (produtos.get(i).getId().equals(id)) {
                novoProduto.setId(id);
                produtos.set(i, novoProduto);
                return "Produto atualizado!";
            }
        }

        return "Produto não encontrado!";
    }

    // DELETE
    @DeleteMapping("/{id}")
    public String deletar(@PathVariable Integer id) {
        produtos.removeIf(produto -> produto.getId().equals(id));
        return "Produto removido!";
    }
    @GetMapping("/teste")
    public String teste() {
    return "FUNCIONANDO";
}
}