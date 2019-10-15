package fr.youness.mescoursesapi.controllers;

import fr.youness.mescoursesapi.beans.Element;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("mes-courses-api")
public class ElementController {

    @GetMapping(value = "/elements")
    public ResponseEntity<List<Element>> getElement() {
        List<Element> _elements = new ArrayList<Element>();
        _elements.add(new Element("Huile", false, 2));
        _elements.add(new Element("Pommes", false, 4));
        return new ResponseEntity<>(_elements, HttpStatus.OK);
    }

}
