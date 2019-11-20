package fr.youness.mesepargnesapi.dao;

import fr.youness.mesepargnesapi.beans.Epargne;
import fr.youness.mesepargnesapi.beans.TypeEpargne;
import fr.youness.mesepargnesapi.beans.Year;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface EpargneDao extends CrudRepository<Epargne, Long> {
    //@Query(value="SELECT * FROM epargne as e WHERE e.year_epargne_id_year = :year", nativeQuery = true)
    @Query("SELECT e FROM Epargne e where e.year_epargne = :year")
    public List<Epargne> getEpargneYear_Epargne(@Param("year") Year year);

    @Query("SELECT e FROM Epargne e where e.type_epargne = :type AND e.year_epargne = :year")
    public List<Epargne> getEpargnesByTypeAndYear(@Param("type") TypeEpargne type, @Param("year") Year year);
}
