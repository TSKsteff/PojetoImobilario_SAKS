
package br.com.saks.Imoveis.Repositorio;


import br.com.saks.Imoveis.Model.TipoImovel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TipoImovelRepositorio extends JpaRepository<TipoImovel,Long>{
    
}
