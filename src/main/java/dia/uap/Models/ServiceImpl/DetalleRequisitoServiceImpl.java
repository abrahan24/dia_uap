package dia.uap.Models.ServiceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import dia.uap.Models.Dao.DetalleRequisitoDao;
import dia.uap.Models.Entity.Detalle_Requisito;
import dia.uap.Models.Service.IDetalleRequisitoService;

@Service
public class DetalleRequisitoServiceImpl implements IDetalleRequisitoService{

    @Autowired
    private DetalleRequisitoDao detalleRequisitoDao;

    @Override
    public List<Detalle_Requisito> findAll() {
        // TODO Auto-generated method stub
        return (List<Detalle_Requisito>) detalleRequisitoDao.findAll();
    }

    @Override
    public void save(Detalle_Requisito detalle_requisito) {
        // TODO Auto-generated method stub
        detalleRequisitoDao.save(detalle_requisito);
    }

    @Override
    public Detalle_Requisito findOne(Long id) {
        // TODO Auto-generated method stub
        return detalleRequisitoDao.findById(id).orElse(null);
    }

    @Override
    public void delete(Long id) {
        // TODO Auto-generated method stub
        detalleRequisitoDao.deleteById(id);
    }
    
}
