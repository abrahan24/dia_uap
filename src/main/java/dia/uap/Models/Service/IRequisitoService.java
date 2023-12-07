package dia.uap.Models.Service;

import java.util.List;

import dia.uap.Models.Entity.Requisito;

public interface IRequisitoService {
     public List<Requisito> findAll();

	public void save(Requisito requisito);

	public Requisito findOne(Long id);

	public void delete(Long id);
}
