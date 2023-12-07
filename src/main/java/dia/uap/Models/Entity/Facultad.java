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
@Table(name = "facultad")
@Setter
@Getter
public class Facultad implements Serializable{
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_facultad;
    private String nom_facultad;
    private String cod_facultad;
    private String estado_facultad;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "facultad", fetch = FetchType.LAZY)
	private List<Carrera> carreras;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "facultad", fetch = FetchType.LAZY)
	private List<Transaccion> transacciones;
}
