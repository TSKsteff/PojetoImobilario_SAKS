
package br.com.saks.Imoveis.Repositorio;


import br.com.saks.Imoveis.Model.Adm;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository 
public interface AdmRepositorio extends JpaRepository<Adm, Long>{
    
}
