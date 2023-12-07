package dia.uap.Models.ServiceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import dia.uap.Models.Dao.ProcesoDao;
import dia.uap.Models.Entity.Proceso;
import dia.uap.Models.Service.IProcesoService;

@Service
public class ProcesoServiceImpl implements IProcesoService{

    @Autowired
    private ProcesoDao procesoDao;

    @Override
    public List<Proceso> findAll() {
        // TODO Auto-generated method stub
        return (List<Proceso>) procesoDao.findAll();
    }

    @Override
    public void save(Proceso proceso) {
        // TODO Auto-generated method stub
        procesoDao.save(proceso);
    }

    @Override
    public Proceso findOne(Long id) {
        // TODO Auto-generated method stub
        return procesoDao.findById(id).orElse(null);
    }

    @Override
    public void delete(Long id) {
        // TODO Auto-generated method stub
        procesoDao.deleteById(id);
    }
    
}
