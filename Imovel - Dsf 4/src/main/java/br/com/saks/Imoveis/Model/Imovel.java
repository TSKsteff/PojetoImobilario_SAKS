package br.com.saks.Imoveis.Model;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import java.io.Serializable;
import java.util.Date;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import lombok.Data;

@Data
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "id")
@Entity
public class Imovel  {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, length = 100)
    private String titulo;

    @Column(nullable = true, length = 500)
    private String descricao;

    @Column(nullable = false, name = "data_criacao")
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date dataCriacao;

    @Column(nullable = true, precision = 8, scale = 2)
    private Double valor;

    @Column(nullable = false, length = 1)
    private int status = 1;

    @ManyToMany
    @JoinTable(
            name = "interesse",
            joinColumns = @JoinColumn(name = "id_imovel"),
            inverseJoinColumns = @JoinColumn(name = "id_cliente")
    )
    private List<Cliente> clientes;
    
    @ManyToOne
    @JoinColumn(name = "id_tipo_imovel")
    private TipoImovel tipoImovel;

}
