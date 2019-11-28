package fr.youness.mesepargnesapi.dao;

import fr.youness.mesepargnesapi.beans.Totaux;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface TotauxDao  extends CrudRepository<Totaux, Long> {

    /*@Query(value = "SELECT type_epargne_id_type as id_type, SUM(montant_epargne) as total_type FROM epargne WHERE date_epargne LIKE CONCAT('%/', :month, '/', :year) GROUP BY type_epargne_id_type", nativeQuery = true)
    List<Totaux> getTotauxOfYear(@Param("year") String year, @Param("month") String month);*/

    @Query(value = "SELECT SUM(montant_epargne) as total_type FROM epargne WHERE date_epargne LIKE CONCAT('%/', :month, '/', :year) AND type_epargne_id_type = :type", nativeQuery = true)
    Double getTotauxByMonthAndType(@Param("year") String year, @Param("month") String month, @Param("type") Long type);

    @Query(value = "SELECT year,  SUM(case when montant > 0 THEN montant ELSE 0 end)as credit FROM totaux GROUP BY year", nativeQuery = true)
    List<?> getTotauxCredit();

    @Query(value = "SELECT year,  SUM(case when montant < 0 THEN montant ELSE 0 end) as deibt FROM totaux GROUP BY year", nativeQuery = true)
    List<?> getTotauxDebit();

    @Query(value = "SELECT year, total_type, montant FROM totaux GROUP BY year, total_type, montant", nativeQuery = true)
    List<?> getTotauxByTypeByYear();
}
