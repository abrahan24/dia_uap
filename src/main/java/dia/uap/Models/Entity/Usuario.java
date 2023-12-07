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
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "usuario")
@Setter
@Getter
public class Usuario implements Serializable{
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_usuario;
    private String nom_usuario;
    private String contrasena;
    private String estado_usuario;
    @DateTimeFormat(pattern = "yyy-MM-dd")
    private Date fecha_registro;
    @DateTimeFormat(pattern = "yyy-MM-dd")
    private Date fecha_modificacion;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_administrativo")
    private Administrativo administrativo;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "usuario", fetch = FetchType.LAZY)
	private List<Transaccion> transacciones;
}
