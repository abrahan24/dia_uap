package dia.uap.Models.Service;

import java.util.List;

import dia.uap.Models.Entity.Nacionalidad;

public interface INacionalidadService {
    
    public List<Nacionalidad> findAll();

	public void save(Nacionalidad nacionalidad);

	public Nacionalidad findOne(Long id);

	public void delete(Long id);
}
