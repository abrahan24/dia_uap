package dia.uap.Models.Dao;

import org.springframework.data.repository.CrudRepository;

import dia.uap.Models.Entity.Persona;

public interface PersonaDao extends CrudRepository<Persona , Long>{
    
}
