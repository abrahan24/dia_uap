package dia.uap.Models.ServiceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import dia.uap.Models.Dao.AdministrativoDao;
import dia.uap.Models.Entity.Administrativo;
import dia.uap.Models.Service.IAdministrativoService;

@Service
public class AdministrativoServiceImpl implements IAdministrativoService{

    @Autowired
    private AdministrativoDao administrativoDao;

    @Override
    public List<Administrativo> findAll() {
        // TODO Auto-generated method stub
        return (List<Administrativo>) administrativoDao.findAll();
    }

    @Override
    public void save(Administrativo administrativo) {
        // TODO Auto-generated method stub
        administrativoDao.save(administrativo);
    }

    @Override
    public Administrativo findOne(Long id) {
        // TODO Auto-generated method stub
        return administrativoDao.findById(id).orElse(null);
    }

    @Override
    public void delete(Long id) {
        // TODO Auto-generated method stub
        administrativoDao.deleteById(id);
    }
    
}
