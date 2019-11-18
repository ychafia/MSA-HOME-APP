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
    public List<Epargne> getEpargnes(String year) {
        List<Epargne> _list = new ArrayList<>();
        epargneDao.getEpargneYear_Epargne(year).forEach(e -> _list.add(e));
        return _list;
    }

    @Override
    public List<Year> getYears() {
        List<Year> _list = new ArrayList<>();
        yearDao.findAll().forEach(e -> _list.add(e));
        return _list;
    }

    @Override
    public List<TypeEpargne> findTypeEpargnesByYear(String year) {
        List<TypeEpargne> _list = new ArrayList<>();
        typeEpargneDao.findTypeEpargnesByYear(year).forEach(e-> _list.add(e));
        return _list;
    }
}