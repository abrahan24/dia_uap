package dia.uap.Models.Entity;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import org.springframework.format.annotation.DateTimeFormat;

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
@Table(name = "proceso")
@Setter
@Getter
public class Proceso implements Serializable{
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_proceso;
    private String nom_proceso;
    @DateTimeFormat(pattern = "yyy-MM-dd")
    private Date fecha_registro;
    @DateTimeFormat(pattern = "yyy-MM-dd")
    private Date fecha_modificacion;
    private String estado_proceso;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "proceso", fetch = FetchType.LAZY)
	private List<Transaccion> transacciones;
}
