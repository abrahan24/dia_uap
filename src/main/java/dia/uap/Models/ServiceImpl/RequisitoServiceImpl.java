package dia.uap.Models.ServiceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import dia.uap.Models.Dao.RequisitoDao;
import dia.uap.Models.Entity.Requisito;
import dia.uap.Models.Service.IRequisitoService;

@Service
public class RequisitoServiceImpl implements IRequisitoService{

    @Autowired
    private RequisitoDao requisitoDao;

    @Override
    public List<Requisito> findAll() {
        // TODO Auto-generated method stub
        return (List<Requisito>) requisitoDao.findAll();
    }

    @Override
    public void save(Requisito requisito) {
        // TODO Auto-generated method stub
        requisitoDao.save(requisito);
    }

    @Override
    public Requisito findOne(Long id) {
        // TODO Auto-generated method stub
        return requisitoDao.findById(id).orElse(null);
    }

    @Override
    public void delete(Long id) {
        // TODO Auto-generated method stub
        requisitoDao.deleteById(id);
    }
    
}
