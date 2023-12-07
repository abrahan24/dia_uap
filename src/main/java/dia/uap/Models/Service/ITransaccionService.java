package dia.uap.Models.Service;

import java.util.List;

import dia.uap.Models.Entity.Transaccion;

public interface ITransaccionService {
    
    public List<Transaccion> findAll();

	public void save(Transaccion transaccion);

	public Transaccion findOne(Long id);

	public void delete(Long id);
}
