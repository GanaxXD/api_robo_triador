package main.java.com.tjma.toadalab.models;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;

@Data
@Setter
@Getter
@EqualsAndHashCode
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Entity(name = "processos_remetidos")
public class ProcessosRemetidosAoSegundoGrau {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@Column(name="data_execucao")
	private LocalDateTime dataExecucao = LocalDateTime.now();
	@Column(name = "quantidade_processos_remetidos", nullable = false)
	private int quantidadeProcessosRemetidos;
	@ManyToOne(targetEntity = Robo.class)
	@JoinColumn(name = "robo_id")
	private Robo roboId;
	@OneToMany(cascade = CascadeType.REMOVE, mappedBy = "processosRemetidosAoSegundoGrau", fetch = FetchType.LAZY)
	private List<Processos> processos;
}
