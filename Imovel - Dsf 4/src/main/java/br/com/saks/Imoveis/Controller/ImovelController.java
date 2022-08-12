package br.com.saks.Imoveis.Controller;

import br.com.saks.Imoveis.Model.Imovel;
import br.com.saks.Imoveis.Repositorio.ImovelRepositorio;
//import br.com.saks.Imoveis.Service.InteresseService;
//import br.com.saks.Imoveis.Service.TipoImovelService;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/imovel")
public class ImovelController {

    @Autowired
    private ImovelRepositorio imovelRepository;

    @Cacheable("listarTodos")
    @GetMapping
    public List<Imovel> listarTodos() {
        return imovelRepository.findAll();
    }

    @Cacheable("listarPeloId")
    @GetMapping(value = "/{id}")
    public Imovel listarPeloId(@PathVariable Long id) {
        Optional<Imovel> imovelResponse = imovelRepository.findById(id);
        Imovel imovel = imovelResponse.get();
        return imovel;
    }

    @GetMapping(value = "/interesse/{id}")
    public Imovel listarPeloComClienteId(@PathVariable Long id) {
        Optional<Imovel> clienteResponse = imovelRepository.findById(id);
        Imovel imovel = clienteResponse.get();
        if (imovel.getStatus() == 0) {
            return null;
        }
        return imovel;
    }

    @PostMapping
    public Imovel adicionar(@RequestBody Imovel imovel) {
        return imovelRepository.save(imovel);
    }

    @PutMapping(value = "/{id}")
    public ResponseEntity editar(@PathVariable Long id, @RequestBody Imovel imovel) {
        Optional<Imovel> clienteResponse = imovelRepository.findById(id);
        Imovel i = clienteResponse.get();
        if (i.getStatus() == 0) {
            return null;
        }
        return imovelRepository.findById(id)
                .map(record -> {
                    record.setTitulo(imovel.getTitulo());
                    record.setDataCriacao(imovel.getDataCriacao());
                    record.setDescricao(imovel.getDescricao());
                    record.setStatus(1);
                    record.setValor(imovel.getValor());
                    record.setClientes(imovel.getClientes());
                    Imovel imovelUpdated = imovelRepository.save(record);
                    return ResponseEntity.ok().body(imovelUpdated);
                }).orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity deletar(@PathVariable Long id) {
        return imovelRepository.findById(id)
                .map(record -> {
                    record.setStatus(0);
                    Imovel imovelUpdated = imovelRepository.save(record);
                    return ResponseEntity.ok().body(imovelUpdated);
                }).orElse(ResponseEntity.notFound().build());
    }

}
