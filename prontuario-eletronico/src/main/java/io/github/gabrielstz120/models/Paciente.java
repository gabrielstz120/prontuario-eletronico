package io.github.gabrielstz120.models;

import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
@ToString
@Entity
@Table(name = "CAD_PACIENTE")
public class Paciente implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long matricula;
    @Column(name = "NOME")
    private String nome;
    @Temporal(TemporalType.DATE)
    @Column(name = "NASCIMENTO", columnDefinition = "date")
    private Date nascimento;
    @Column(name = "CPF")
    private Long cpf;

}
