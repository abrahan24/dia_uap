package dia.uap.Models.ServiceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import dia.uap.Models.Dao.PostulanteDao;
import dia.uap.Models.Entity.Postulante;
import dia.uap.Models.Service.IPostulanteService;

@Service
public class PostulanteServiceImpl implements IPostulanteService{

    @Autowired
    private PostulanteDao postulanteDao;

    @Override
    public List<Postulante> findAll() {
        // TODO Auto-generated method stub
        return (List<Postulante>) postulanteDao.findAll();
    }

    @Override
    public void save(Postulante postulante) {
        // TODO Auto-generated method stub
        postulanteDao.save(postulante);
    }

    @Override
    public Postulante findOne(Long id) {
        // TODO Auto-generated method stub
        return postulanteDao.findById(id).orElse(null);
    }

    @Override
    public void delete(Long id) {
        // TODO Auto-generated method stub
        postulanteDao.deleteById(id);
    }
    
}
