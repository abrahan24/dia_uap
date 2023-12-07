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
@Table(name = "detalle_requisito")
@Setter
@Getter
public class Detalle_Requisito implements Serializable{
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_detalle_requisito;
    @DateTimeFormat(pattern = "yyy-MM-dd")
    private Date fecha_registro;
    @DateTimeFormat(pattern = "yyy-MM-dd")
    private Date fecha_modificacion;
    private String estado_detalle_requisito;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_postulante")
    private Postulante postulante;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_requisito")
    private Requisito requisito;
}
