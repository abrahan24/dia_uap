package dia.uap.Models.Dao;

import org.springframework.data.repository.CrudRepository;

import dia.uap.Models.Entity.Usuario;

public interface UsuarioDao extends CrudRepository<Usuario , Long> {

} 
