package fr.youness.mesepargnesapi.dao;

import fr.youness.mesepargnesapi.beans.TypeEpargne;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface TypeEpargneDao extends CrudRepository<TypeEpargne, Long> {
    @Query(value = "SELECT  * " +
            "FROM type_epargne as type, type_epargne_year as yt, year as y " +
            "WHERE type.id_type = yt.type_epargne_id_type AND yt.year_id_year = y.id_year " +
            "AND y.value_year = :year", nativeQuery = true)
    List<TypeEpargne> findTypeEpargnesByYear(@Param("year") String year);
}
