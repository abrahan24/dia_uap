package dia.uap.Models.Dao;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import dia.uap.Models.Entity.Usuario;

public interface UsuarioDao extends CrudRepository<Usuario , Long> {

    @Query(value = "select * from usuario u where u.nom_usuario =?1 and u.contrasena =?2",nativeQuery = true)
    public Usuario getUsuario(String nom_usuario, String contrasena);
} 
