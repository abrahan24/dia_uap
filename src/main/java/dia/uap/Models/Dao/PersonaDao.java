package dia.uap.Models.Dao;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import dia.uap.Models.Entity.Persona;

public interface PersonaDao extends CrudRepository<Persona , Long>{
    
    @Query(value = "select * from persona p where p.ci =?1",nativeQuery = true)
    public Persona getPersona_Por_CI(String ci); 
}
