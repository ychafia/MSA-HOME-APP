package fr.youness.mesepargnesapi.services;

import fr.youness.mesepargnesapi.beans.Epargne;
import fr.youness.mesepargnesapi.beans.TypeEpargne;
import fr.youness.mesepargnesapi.beans.Year;
import fr.youness.mesepargnesapi.dao.EpargneDao;
import fr.youness.mesepargnesapi.dao.TypeEpargneDao;
import fr.youness.mesepargnesapi.dao.YearDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class EpargneService  implements IEpargneService{
    @Autowired
    private EpargneDao epargneDao;

    @Autowired
    private YearDao yearDao;

    @Autowired
    private TypeEpargneDao typeEpargneDao;

    @Override
    public List<Epargne> getAllEpargnes() {
        List<Epargne> _list = new ArrayList<>();
        epargneDao.findAll().forEach(e -> _list.add(e));
        return _list;
    }

    @Override
    public List<Epargne> getEpargnes(Year year) {
        List<Epargne> _list = new ArrayList<>();
        epargneDao.getEpargneYear_Epargne(year).forEach(e -> _list.add(e));
        return _list;
    }

    @Override
    public List<Epargne> getEpargnesByTypeAndYear(TypeEpargne type, Year year) {
        List<Epargne> _list = new ArrayList<>();
        epargneDao.getEpargnesByTypeAndYear(type, year).forEach(e -> _list.add(e));
        return _list;
    }


    @Override
    public List<Year> getYears() {
        List<Year> _list = new ArrayList<>();
        yearDao.findAll().forEach(e -> _list.add(e));
        return _list;
    }

    @Override
    public Year findByVlue(String year) {
        return yearDao.findByValue(year);
    }

    @Override
    public Year findActiveYear() {
        return yearDao.findActiveYear();
    }

    @Override
    public List<TypeEpargne> findTypeEpargnesByYear(String year) {
        List<TypeEpargne> _list = new ArrayList<>();
        typeEpargneDao.findTypeEpargnesByYear(year).forEach(e-> _list.add(e));
        return _list;
    }

    @Override
    public TypeEpargne findTypeEpargnesByValue(String value) {
        return typeEpargneDao.findTypeEpargnesByValue(value);
    }

    @Override
    public Epargne addUpdateEpargne(Epargne epargne) {
        return epargneDao.save(epargne);
    }

    @Override
    public boolean deleteEpargne(Long id) {
        if(epargneDao.findById(id).isPresent()) {
            epargneDao.deleteById(id);
            return true;
        }
        return false;
    }
}
