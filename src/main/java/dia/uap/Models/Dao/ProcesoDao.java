package dia.uap.Models.Dao;

import org.springframework.data.repository.CrudRepository;

import dia.uap.Models.Entity.Proceso;

public interface ProcesoDao extends CrudRepository<Proceso, Long>{
    
}
