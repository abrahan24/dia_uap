package dia.uap.Models.ServiceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import dia.uap.Models.Dao.ColegioDao;
import dia.uap.Models.Entity.Colegio;
import dia.uap.Models.Service.IColegioService;

@Service
public class ColegioServiceImpl implements IColegioService{

    @Autowired
    private ColegioDao colegioDao;

    @Override
    public List<Colegio> findAll() {
        // TODO Auto-generated method stub
        return (List<Colegio>) colegioDao.findAll();
    }

    @Override
    public void save(Colegio colegio) {
        // TODO Auto-generated method stub
        colegioDao.save(colegio);
    }

    @Override
    public Colegio findOne(Long id) {
        // TODO Auto-generated method stub
        return colegioDao.findById(id).orElse(null);
    }

    @Override
    public void delete(Long id) {
        // TODO Auto-generated method stub
        colegioDao.deleteById(id);
    }
    
}
