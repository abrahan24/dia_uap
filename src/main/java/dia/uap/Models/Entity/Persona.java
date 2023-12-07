package dia.uap.Models.Entity;

import java.io.Serializable;
import java.util.Date;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "persona")
@Setter
@Getter
public class Persona implements Serializable{
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_persona;
    private String nom_persona;
    private String ap_paterno;
    private String ap_materno;
    private String ci;
    private String genero;
    private String correo;
    private String celular;
    private String estado_persona;
    private Date fecha_nacimiento;
    private Date fecha_registro;
    private Date fecha_modificacion;
}
