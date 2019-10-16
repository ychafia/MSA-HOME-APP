package fr.youness.mescoursesapi.controllers;

import fr.youness.mescoursesapi.beans.Element;
import fr.youness.mescoursesapi.services.IElementService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("mes-courses-api")
@CrossOrigin
public class ElementController {
    @Autowired
    private IElementService elementService;

    @GetMapping(value = "/elements")
    public ResponseEntity<List<Element>> getElement() {
        return new ResponseEntity<>(elementService.getElements(), HttpStatus.OK);
    }

    @PostMapping(value = "/element")
    public ResponseEntity<?> addElement(@RequestBody Element element) {
        Element _element = elementService.updateAndSaveElement(element);
        return new ResponseEntity<>(_element.getId_element(), HttpStatus.CREATED);
    }

    @DeleteMapping(value = "/element/{id}")
    public ResponseEntity<?> deleteElement(@PathVariable Long id) {
        return new ResponseEntity<>(elementService.deleteElement(id), HttpStatus.OK);
    }

}
