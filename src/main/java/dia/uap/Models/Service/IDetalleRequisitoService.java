package dia.uap.Models.Service;

import java.util.List;

import dia.uap.Models.Entity.Detalle_Requisito;

public interface IDetalleRequisitoService {

    public List<Detalle_Requisito> findAll();

	public void save(Detalle_Requisito detalle_requisito);

	public Detalle_Requisito findOne(Long id);

	public void delete(Long id);
}
