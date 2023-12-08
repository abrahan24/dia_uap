package dia.uap.Models.ServiceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import dia.uap.Models.Dao.PersonaDao;
import dia.uap.Models.Entity.Persona;
import dia.uap.Models.Service.IPersonaService;

@Service
public class PersonaServiceImpl implements IPersonaService{

    @Autowired
    private PersonaDao personaDao;

    @Override
    public List<Persona> findAll() {
        // TODO Auto-generated method stub
        return (List<Persona>) personaDao.findAll();
    }

    @Override
    public void save(Persona persona) {
        // TODO Auto-generated method stub
        personaDao.save(persona);
    }

    @Override
    public Persona findOne(Long id) {
        // TODO Auto-generated method stub
        return personaDao.findById(id).orElse(null);
    }

    @Override
    public void delete(Long id) {
        // TODO Auto-generated method stub
        personaDao.deleteById(id);
    }

    @Override
    public Persona getPersona_Por_CI(String ci) {
        // TODO Auto-generated method stub
        return personaDao.getPersona_Por_CI(ci);
    }
    
}
