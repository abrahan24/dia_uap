package dia.uap.Models.ServiceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import dia.uap.Models.Dao.NacionalidadDao;
import dia.uap.Models.Entity.Nacionalidad;
import dia.uap.Models.Service.INacionalidadService;

@Service
public class NacionalidadServiceImpl implements INacionalidadService{

    @Autowired
    private NacionalidadDao nacionalidadDao;

    @Override
    public List<Nacionalidad> findAll() {
        // TODO Auto-generated method stub
        return (List<Nacionalidad>) nacionalidadDao.findAll();
    }

    @Override
    public void save(Nacionalidad nacionalidad) {
        // TODO Auto-generated method stub
        nacionalidadDao.save(nacionalidad);
    }

    @Override
    public Nacionalidad findOne(Long id) {
        // TODO Auto-generated method stub
        return nacionalidadDao.findById(id).orElse(null);
    }

    @Override
    public void delete(Long id) {
        // TODO Auto-generated method stub
        nacionalidadDao.deleteById(id);
    }
    
}
