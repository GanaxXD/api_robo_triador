package main.java.com.tjma.toadalab.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.*;

@Data
@Setter
@Getter
@Entity(name = "processos")
@EqualsAndHashCode
@AllArgsConstructor
@NoArgsConstructor
public class Processos {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "numero_processo", length = 25, nullable = false)
    private String numeroProcesso;

    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "id_processo_remetido")
    private ProcessosRemetidosAoSegundoGrau processosRemetidosAoSegundoGrau;
    @Override
    public String toString(){
        return "Processo: "+id+" - "+numeroProcesso;
    }
}
