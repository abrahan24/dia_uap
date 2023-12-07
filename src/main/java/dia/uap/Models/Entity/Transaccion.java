package dia.uap.Models.Entity;

import java.io.Serializable;
import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "transaccion")
@Setter
@Getter
public class Transaccion implements Serializable{
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_transaccion;
    private Integer pago;
    @DateTimeFormat(pattern = "yyy-MM-dd")
    private Date fecha_pago;
    private Integer descuento;
    private Integer nro_recibo;
    private Integer gestion;
    private String periodo;
    @DateTimeFormat(pattern = "yyy-MM-dd")
    private Date fecha_regstro;
    @DateTimeFormat(pattern = "yyy-MM-dd")
    private Date fecha_modificacion;
    private String estado_transaccion;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_postulante")
    private Postulante postulante;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_carrera")
    private Carrera carrera;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_facultad")
    private Facultad facultad;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_usuario")
    private Usuario usuario;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_ventanilla")
    private Ventanilla ventanilla;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_proceso")
    private Proceso proceso;

}
