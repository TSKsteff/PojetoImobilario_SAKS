
package br.com.saks.Imoveis.Repositorio;

import br.com.saks.Imoveis.Model.Imovel;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ImovelRepositorio extends JpaRepository<Imovel,Long> {
}
