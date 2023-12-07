package dia.uap.Models.Service;

import java.util.List;

import dia.uap.Models.Entity.Persona;

public interface IPersonaService {

    public List<Persona> findAll();

	public void save(Persona persona);

	public Persona findOne(Long id);

	public void delete(Long id);
}
