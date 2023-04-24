    package com.teste.minimercado.controller;

    import com.teste.minimercado.model.Produto;
    import com.teste.minimercado.services.ProdutoService;
    import org.springframework.beans.factory.annotation.Autowired;
    import org.springframework.web.bind.annotation.*;

    import java.util.List;
    import java.util.Optional;

    @RestController
    @RequestMapping("/api/produtos")
    public class ProdutoController {

        @Autowired
        private ProdutoService produtoService;

        @GetMapping
        public List<Produto> obterTodos() {
            return produtoService.obterTodos();
        }

        @GetMapping("/{id}")
        public Optional<Produto> obterPorId(@PathVariable Integer id) {
            return produtoService.obterPorId(id);
        }

        @PostMapping
        public Produto adicionar(@RequestBody Produto produto) {
            return produtoService.adicionar(produto);
        }

        @DeleteMapping("/{id}")
        public String deletar(@PathVariable Integer id) {
            produtoService.deletar(id);
            return "Produto com id:" + id + "foi deletado com sucesso";
        }

        @PutMapping("/{id}")
        public Produto atualizar(@PathVariable Integer id, @RequestBody Produto produto) {
            return produtoService.atualizar(id, produto);
        }
    }
