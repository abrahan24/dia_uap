package dia.uap.Models.Service;

import java.util.List;

import dia.uap.Models.Entity.TipoPostulante;

public interface ITipoPostulanteService {
    public List<TipoPostulante> findAll();

	public void save(TipoPostulante tipoPostulante);

	public TipoPostulante findOne(Long id);

	public void delete(Long id);
}
