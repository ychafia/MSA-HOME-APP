package fr.youness.mesepargnesapi.dao;

import fr.youness.mesepargnesapi.beans.Epargne;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface EpargneDao extends CrudRepository<Epargne, Long> {
    @Query(value="SELECT * FROM epargne as e WHERE e.year_epargne = :year", nativeQuery = true)
    public List<Epargne> getEpargneYear_Epargne(@Param("year") String year);
}
