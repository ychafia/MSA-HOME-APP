package fr.youness.mesepargnesapi.dao;

import fr.youness.mesepargnesapi.beans.Year;
import org.springframework.data.repository.CrudRepository;

public interface YearDao extends CrudRepository<Year, Long> {
}
