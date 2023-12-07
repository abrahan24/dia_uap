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
@Table(name = "tipo_postulante")
@Setter
@Getter
public class TipoPostulante implements Serializable{
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_tipo_postulante;
    private String descri_tipo_postulante;
    private String estado_tipo_postulante;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "tipoPostulante", fetch = FetchType.LAZY)
	private List<Postulante> postulantes;
}
