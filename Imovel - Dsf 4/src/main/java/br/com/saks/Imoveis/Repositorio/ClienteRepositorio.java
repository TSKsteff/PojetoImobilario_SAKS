
package br.com.saks.Imoveis.Repositorio;


import br.com.saks.Imoveis.Model.Adm;
import br.com.saks.Imoveis.Model.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClienteRepositorio extends JpaRepository<Cliente, Long>{

    
}
