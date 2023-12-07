package dia.uap.Models.Entity;

import java.io.Serializable;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "colegio")
@Setter
@Getter
public class Colegio implements Serializable{
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_colegio;
    private String nom_colegio;
    private String tipo_institucion;
    private String turno;
    private String estado_colegio;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "colegio", fetch = FetchType.LAZY)
	private List<Postulante> postulantes;
}
