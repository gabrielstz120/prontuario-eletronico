package io.github.gabrielstz120.models;

import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
@ToString
@Entity
@Table(name = "MOV_EXAMES")
public class Exame implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    @Column(name = "EXAME")
    private String exame;
    @Temporal(TemporalType.DATE)
    @Column(name = "DATA", columnDefinition = "date")
    private Date data;
    @Column(name = "VALOR_EXAME")
    private String valorExame;
}
