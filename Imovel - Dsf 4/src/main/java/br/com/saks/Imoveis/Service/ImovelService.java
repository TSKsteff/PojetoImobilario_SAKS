/*
package br.com.saks.Imoveis.Service;

import br.com.saks.Imoveis.Model.Imovel;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name="imovel-service")
public interface ImovelService {
    @GetMapping(value="/imovel/{idImovel}")
    Imovel listarPeloId(@PathVariable("idImovel") Long idImovel);
    @GetMapping(value="/imovel/tipoImovel/{id}")
    Imovel[] listarImovelPeloTipo(@PathVariable("id") Long id);
}
*/