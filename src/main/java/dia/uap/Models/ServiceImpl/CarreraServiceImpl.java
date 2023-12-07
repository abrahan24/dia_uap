package dia.uap.Models.ServiceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import dia.uap.Models.Dao.CarreraDao;
import dia.uap.Models.Entity.Carrera;
import dia.uap.Models.Service.ICarreraService;

@Service
public class CarreraServiceImpl implements ICarreraService{

    @Autowired
    private CarreraDao carreraDao;

    @Override
    public List<Carrera> findAll() {
        // TODO Auto-generated method stub
        return (List<Carrera>) carreraDao.findAll();
    }

    @Override
    public void save(Carrera carrera) {
        // TODO Auto-generated method stub
        carreraDao.save(carrera);
    }

    @Override
    public Carrera findOne(Long id) {
        // TODO Auto-generated method stub
        return carreraDao.findById(id).orElse(null);
    }

    @Override
    public void delete(Long id) {
        // TODO Auto-generated method stub
        carreraDao.deleteById(id);
    }
    
}
