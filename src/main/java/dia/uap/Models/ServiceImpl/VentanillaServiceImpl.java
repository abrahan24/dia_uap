package dia.uap.Models.ServiceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import dia.uap.Models.Dao.VentanillaDao;
import dia.uap.Models.Entity.Ventanilla;
import dia.uap.Models.Service.IVentanillaService;

@Service
public class VentanillaServiceImpl implements IVentanillaService{

    @Autowired
    private VentanillaDao ventanillaDao;

    @Override
    public List<Ventanilla> findAll() {
        // TODO Auto-generated method stub
        return (List<Ventanilla>) ventanillaDao.findAll();
    }

    @Override
    public void save(Ventanilla ventanilla) {
        // TODO Auto-generated method stub
        ventanillaDao.save(ventanilla);
    }

    @Override
    public Ventanilla findOne(Long id) {
        // TODO Auto-generated method stub
        return ventanillaDao.findById(id).orElse(null);
    }

    @Override
    public void delete(Long id) {
        // TODO Auto-generated method stub
        ventanillaDao.deleteById(id);
    }
    
}
