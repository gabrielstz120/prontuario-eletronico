package io.github.gabrielstz120.models;

import lombok.*;

import javax.persistence.*;
import java.io.Serializable;

@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
@ToString
@Entity
@Table(name = "CAD_MEDICO")
public class Medico implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Column(name = "NOME")
    private String nome;
    @Column(name = "NUMERO_CONSELHO")
    private Long numeroConselho;
    @Column(name = "CONSELHO_REGIONAL")
    private String conselhoRegional;
    @Column(name = "STATUS", columnDefinition = "boolean")
    private Boolean status;
    @Column(name = "CELULAR")
    private String celular;
    @Column(name = "TEL_COMERCIAL")
    private String telComercial;
    @Column(name = "EMAIL")
    private String email;

}

