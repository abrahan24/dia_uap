package dia.uap.Models.Dao;

import org.springframework.data.repository.CrudRepository;

import dia.uap.Models.Entity.Transaccion;

public interface TransaccionDao extends CrudRepository<Transaccion,Long>{
    
}
