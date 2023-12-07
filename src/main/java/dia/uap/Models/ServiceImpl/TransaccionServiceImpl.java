package dia.uap.Models.ServiceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import dia.uap.Models.Dao.TransaccionDao;
import dia.uap.Models.Entity.Transaccion;
import dia.uap.Models.Service.ITransaccionService;

@Service
public class TransaccionServiceImpl implements ITransaccionService{

    @Autowired
    private TransaccionDao transaccionDao;

    @Override
    public List<Transaccion> findAll() {
        // TODO Auto-generated method stub
        return (List<Transaccion>) transaccionDao.findAll();
    }

    @Override
    public void save(Transaccion transaccion) {
        // TODO Auto-generated method stub
        transaccionDao.save(transaccion);
    }

    @Override
    public Transaccion findOne(Long id) {
        // TODO Auto-generated method stub
        return transaccionDao.findById(id).orElse(null);
    }

    @Override
    public void delete(Long id) {
        // TODO Auto-generated method stub
        transaccionDao.deleteById(id);
    }
    
}
