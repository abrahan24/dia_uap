package dia.uap.Models.Service;

import java.util.List;

import dia.uap.Models.Entity.Administrativo;

public interface IAdministrativoService {

    public List<Administrativo> findAll();

	public void save(Administrativo administrativo);

	public Administrativo findOne(Long id);

	public void delete(Long id);
}
