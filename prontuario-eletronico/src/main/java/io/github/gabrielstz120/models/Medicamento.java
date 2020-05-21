package io.github.gabrielstz120.models;

import lombok.*;

import javax.persistence.*;
import java.io.Serializable;

@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
@ToString
@Entity
@Table(name = "MOV_MEDICAMENTO")
public class Medicamento implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    @Column(name = "VIA")
    private String via;
    @Column(name = "MEDICAMENTO")
    private String medicamento;
    @Column(name = "QUANTIDADE")
    private String quantidade;
    @Column(name = "PERIODICIDADE")
    private String periodicidade;
    @Column(name = "TEMPO_USO")
    private String tempoUso;
}
