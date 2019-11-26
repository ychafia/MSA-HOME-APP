package fr.youness.mesepargnesapi.dao;

import fr.youness.mesepargnesapi.beans.Totaux;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface TotauxDao  extends CrudRepository<Totaux, Long> {

    @Query(value = "SELECT type_epargne_id_type as id_type, SUM(montant_epargne) as total_type FROM epargne WHERE date_epargne LIKE CONCAT('%/', :month, '/', :year) GROUP BY type_epargne_id_type", nativeQuery = true)
    List<Totaux> getTotauxOfYear(@Param("year") String year, @Param("month") String month);

    @Query(value = "SELECT SUM(montant_epargne) as total_type FROM epargne WHERE date_epargne LIKE CONCAT('%/', :month, '/', :year) AND type_epargne_id_type = :type", nativeQuery = true)
    Double getTotauxByMonthAndType(@Param("year") String year, @Param("month") String month, @Param("type") Long type);
}
