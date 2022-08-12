
package br.com.saks.Imoveis.Controller;

import br.com.saks.Imoveis.Model.Categoria;
import br.com.saks.Imoveis.Repositorio.CategoriaRepositorio;

import java.util.List;
import java.util.Optional;

import org.springframework.cache.annotation.Cacheable;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RequestMapping("/categorias")
@RestController
public class CategoriaController {
    @Autowired
    private CategoriaRepositorio categoriaRepository;
   
    
    @PostMapping
    public Categoria adicionar(@RequestBody Categoria categoria) {
        return categoriaRepository.save(categoria);
    }
  //  @Cacheable("listarporid")
    @GetMapping
    public List<Categoria> listarTodos() {
        return categoriaRepository.findAll();
    }
  //  @Cacheable("listarporid")
    @GetMapping(value = "/{id}")
    public Optional<Categoria> listarPeloId(@PathVariable Long id) {
        return categoriaRepository.findById(id);
    }

    @PutMapping(value = "/{id}")
    public ResponseEntity editar(@PathVariable Long id, @RequestBody Categoria categoria) {
        return categoriaRepository.findById(id)
                .map(record -> {
                    record.setNome(categoria.getNome());
                    Categoria livroUpdated = categoriaRepository.save(record);
                    return ResponseEntity.ok().body(livroUpdated);
                }).orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity deletar(@PathVariable Long id) {
        return categoriaRepository.findById(id)
                .map(record -> {
                    categoriaRepository.deleteById(id);
                    return ResponseEntity.ok().build();
                }).orElse(ResponseEntity.notFound().build());
    }
}
