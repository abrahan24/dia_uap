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
@Table(name = "nacionalidad")
@Setter
@Getter
public class Nacionalidad implements Serializable{
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_nacionalidad;
    private String nom_nacionalidad;
    private String codigo_nacionalidad;
    private String descripcion_nacionalidad;
    private String estado_nacionalidad;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "nacionalidad", fetch = FetchType.LAZY)
	private List<Persona> personas;
}
