package fr.youness.mesnotesapi.services;

import fr.youness.mesnotesapi.beans.Note;
import fr.youness.mesnotesapi.dao.NoteDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class NoteService implements INoteService {
    @Autowired
    private NoteDao noteDao;

    @Override
    public List<Note> getNotes() {
        List<Note> list = new ArrayList<>();
        noteDao.findAll().forEach(e -> list.add(e));
        return list;
    }

    @Override
    public Note getNotesById(Long id) {
        Note _note = new Note();
        if(noteDao.findById(id).isPresent()) {
            _note = noteDao.findById(id).get();
        } else {
            _note = null;
        }
        return _note;
    }

    @Override
    public boolean deleteNote(Long id) {
        if(noteDao.findById(id).isPresent()) {
            noteDao.deleteById(id);
            return  true;
        }
        return false;
    }

    @Override
    public Note updateAndSaveNote(Note n) {
        return noteDao.save(n);
    }
}
