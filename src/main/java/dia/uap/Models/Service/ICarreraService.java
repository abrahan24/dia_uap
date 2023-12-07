package dia.uap.Models.Service;

import java.util.List;

import dia.uap.Models.Entity.Carrera;

public interface ICarreraService {
    public List<Carrera> findAll();

	public void save(Carrera carrera);

	public Carrera findOne(Long id);

	public void delete(Long id);
}
