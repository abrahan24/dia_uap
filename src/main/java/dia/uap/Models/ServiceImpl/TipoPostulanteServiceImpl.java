package dia.uap.Models.ServiceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import dia.uap.Models.Dao.TipoPostulanteDao;
import dia.uap.Models.Entity.TipoPostulante;
import dia.uap.Models.Service.ITipoPostulanteService;

@Service
public class TipoPostulanteServiceImpl implements ITipoPostulanteService{

    @Autowired
    private TipoPostulanteDao tipoPostulanteDao;

    @Override
    public List<TipoPostulante> findAll() {
        // TODO Auto-generated method stub
        return (List<TipoPostulante>) tipoPostulanteDao.findAll();
    }

    @Override
    public void save(TipoPostulante tipoPostulante) {
        // TODO Auto-generated method stub
        tipoPostulanteDao.save(tipoPostulante);
    }

    @Override
    public TipoPostulante findOne(Long id) {
        // TODO Auto-generated method stub
        return tipoPostulanteDao.findById(id).orElse(null);
    }

    @Override
    public void delete(Long id) {
        // TODO Auto-generated method stub
        tipoPostulanteDao.deleteById(id);
    }
    
}
