package fr.youness.mesepargnesapi.services;

import fr.youness.mesepargnesapi.beans.Epargne;
import fr.youness.mesepargnesapi.beans.Totaux;
import fr.youness.mesepargnesapi.beans.TypeEpargne;
import fr.youness.mesepargnesapi.beans.Year;
import org.springframework.web.bind.annotation.RequestBody;

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
    //List<Totaux> getTotauxOfYear(String year, String month);
    //List<?> getTotaux();
    List<?> getTotauxCredit();
    List<?> getTotauxDebit();
    List<?> getTotaux();
    List<?> getTotauxByTypeByYear(String year);
    Double getTotauxByMonthAndType(String year, String month, Long type);
    int updateTotaux(Double new_solde, String year, Long id_type);
    Totaux addTotaux(Totaux total);
    int totalIsExist(Integer year, Long id_type);

}
