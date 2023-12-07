package dia.uap.Models.Service;

import java.util.List;

import dia.uap.Models.Entity.Ventanilla;

public interface IVentanillaService {
     public List<Ventanilla> findAll();

	public void save(Ventanilla ventanilla);

	public Ventanilla findOne(Long id);

	public void delete(Long id);
}
