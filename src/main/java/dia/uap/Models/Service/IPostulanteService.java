package dia.uap.Models.Service;

import java.util.List;

import dia.uap.Models.Entity.Postulante;

public interface IPostulanteService {
     public List<Postulante> findAll();

	public void save(Postulante postulante);

	public Postulante findOne(Long id);

	public void delete(Long id);
}
