package fr.youness.mesnotesapi.controllers;

import fr.youness.mesnotesapi.beans.Note;
import fr.youness.mesnotesapi.config.MesNotesPropertiesConfiguration;
import fr.youness.mesnotesapi.services.INoteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("mes-notes-api")
@CrossOrigin
public class NoteController {
    @Autowired
    private INoteService noteService;

    @Autowired
    MesNotesPropertiesConfiguration mesNotesConfig;

    @GetMapping(value = "/notes")
    public ResponseEntity<List<Note>> getNotes() {
        return new ResponseEntity<>(noteService.getNotes().subList(0, mesNotesConfig.getLimitReturnedNotes()), HttpStatus.OK);
    }

    @GetMapping(value = "/notes/{id}")
    public ResponseEntity<Note> getNotesById(@PathVariable Long id) {
        return new ResponseEntity<Note>(noteService.getNotesById(id), HttpStatus.OK);
    }

    @PostMapping(value = "/note")
    public ResponseEntity<?> addNote(@RequestBody Note note) {
        Note _note = noteService.updateAndSaveNote(note);
        return new ResponseEntity<>(_note.getId_note(), HttpStatus.CREATED);
    }

    @DeleteMapping(value = "/note/{id}")
    public ResponseEntity<?> deleteNote(@PathVariable Long id) {
        return new ResponseEntity<>(noteService.deleteNote(id), HttpStatus.OK);
    }
}
