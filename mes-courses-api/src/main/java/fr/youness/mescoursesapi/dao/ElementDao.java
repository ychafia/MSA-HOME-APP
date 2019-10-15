package fr.youness.mescoursesapi.dao;

import fr.youness.mescoursesapi.beans.Element;
import org.springframework.data.repository.CrudRepository;

public interface ElementDao extends CrudRepository<Element, Long> {
}
