package dia.uap.Models.Service;

import java.util.List;

import dia.uap.Models.Entity.Proceso;

public interface IProcesoService {
    public List<Proceso> findAll();

	public void save(Proceso proceso);

	public Proceso findOne(Long id);

	public void delete(Long id);
}
