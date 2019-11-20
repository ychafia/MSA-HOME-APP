package fr.youness.mesepargnesapi.services;

import fr.youness.mesepargnesapi.beans.Epargne;
import fr.youness.mesepargnesapi.beans.TypeEpargne;
import fr.youness.mesepargnesapi.beans.Year;

import java.util.List;


public interface IEpargneService {
    List<Epargne> getAllEpargnes();
    List<Epargne> getEpargnes(Year year);
    List<Epargne> getEpargnesByTypeAndYear(TypeEpargne type, Year year);
    List<Year> getYears();
    Year findByVlue(String year);
    Year findActiveYear();
    List<TypeEpargne> findTypeEpargnesByYear(String year);
    TypeEpargne findTypeEpargnesByValue(String value);
    Epargne addUpdateEpargne(Epargne epargne);
    boolean deleteEpargne(Long id);
}
