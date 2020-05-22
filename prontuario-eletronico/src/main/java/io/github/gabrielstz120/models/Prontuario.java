package io.github.gabrielstz120.models;

import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
@ToString
@Entity
@Table(name = "MOV_PRONTUARIO")
public class Prontuario implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Temporal(TemporalType.DATE)
    @Column(name = "DATA", columnDefinition = "date")
    private Date data;
    @Column(name = "CPF")
    private Long cpf;
    @Column(name = "NOME_MEDICO")
    private String nomeMedico;
    @Column(name = "CID")
    private String cid;
    @Column(name = "ATENDIMENTO")
    private String atendimento;
    @Column(name = "SITUACAO", columnDefinition = "boolean")
    private Boolean situacao;
    @Column(name = "LOCALIZACAO")
    private String localizacao;

}
