package dia.uap.Models.Service;

import java.util.List;

import dia.uap.Models.Entity.Facultad;

public interface IFacultadService {
    public List<Facultad> findAll();

	public void save(Facultad facultad);

	public Facultad findOne(Long id);

	public void delete(Long id);
}
