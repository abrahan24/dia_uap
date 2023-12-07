package dia.uap.Models.Service;

import java.util.List;

import dia.uap.Models.Entity.Colegio;

public interface IColegioService {
    public List<Colegio> findAll();

	public void save(Colegio colegio);

	public Colegio findOne(Long id);

	public void delete(Long id);
}
