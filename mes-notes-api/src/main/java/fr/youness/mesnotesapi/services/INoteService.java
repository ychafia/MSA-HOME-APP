package fr.youness.mesnotesapi.services;

import fr.youness.mesnotesapi.beans.Note;

import java.util.List;

public interface INoteService {
    List<Note> getNotes();
    public Note getNotesById(Long id) ;
    public boolean deleteNote(Long id);
    public Note updateAndSaveNote(Note n);
}
