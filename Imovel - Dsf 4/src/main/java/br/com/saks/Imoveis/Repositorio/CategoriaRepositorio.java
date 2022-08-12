
package br.com.saks.Imoveis.Repositorio;


import br.com.saks.Imoveis.Model.Categoria;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


public interface CategoriaRepositorio extends JpaRepository<Categoria, Long> {
    
}
