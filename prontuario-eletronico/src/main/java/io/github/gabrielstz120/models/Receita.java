package io.github.gabrielstz120.models;

import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
@ToString
@Entity
@Table(name = "CAD_RECEITA")
public class Receita implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Temporal(TemporalType.DATE)
    @Column(name = "DATA", columnDefinition = "date")
    private Date data;
    @Column(name = "CPF_PACIENTE")
    private Long cpfPaciente;
    @Column(name = "NOME_MEDICO")
    private String nomeMedico;
    @OneToMany
    private List<Medicamento> medicamento;
}

