package fr.youness.mesnotesapi.dao;

import fr.youness.mesnotesapi.beans.Note;
import org.springframework.data.repository.CrudRepository;

public interface NoteDao extends CrudRepository<Note, Long> {
}
