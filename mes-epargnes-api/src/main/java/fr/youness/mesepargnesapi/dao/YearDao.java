package fr.youness.mesepargnesapi.dao;

import fr.youness.mesepargnesapi.beans.Year;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

public interface YearDao extends CrudRepository<Year, Long> {
    @Query("SELECT y FROM Year y where value_year = :year")
    Year findByValue(@Param("year") String year);
}
