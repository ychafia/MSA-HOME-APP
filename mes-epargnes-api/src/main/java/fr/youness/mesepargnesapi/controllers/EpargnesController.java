package fr.youness.mesepargnesapi.controllers;

import fr.youness.mesepargnesapi.beans.Epargne;
import fr.youness.mesepargnesapi.beans.TypeEpargne;
import fr.youness.mesepargnesapi.beans.Year;
import fr.youness.mesepargnesapi.services.IEpargneService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@RestController
@RequestMapping("mes-epargnes-api")
@CrossOrigin
public class EpargnesController {
    @Autowired
    private IEpargneService epargneService;

    @GetMapping(value = "/epargnes")
    public ResponseEntity<List<Epargne>> getAllEpargnes() {
        System.out.println("No year ");
        return new ResponseEntity<>(epargneService.getAllEpargnes(), HttpStatus.OK);
    }

    @GetMapping(value = "/epargnes/{year}")
    public ResponseEntity<?> getEpargnes(@PathVariable String year) {
        /*Year _year = epargneService.findByVlue(year);
        System.out.println("year :" + _year);
        List<Epargne> _list = epargneService.getEpargnes(_year);
        return new ResponseEntity<>(_list, HttpStatus.OK);*/
        ArrayList<Object> array1 = new ArrayList<>();
        List<TypeEpargne> _list = epargneService.findTypeEpargnesByYear(year);
        Year _year = epargneService.findByVlue(year);
        for (TypeEpargne type_ep : _list){
            HashMap<String, Object> map2 = new HashMap<>();
            map2.put("type", type_ep.getValue_type());
            map2.put("epargnes", epargneService.getEpargnesByType(type_ep));
            array1.add(map2);
        }
        return new ResponseEntity<>(array1, HttpStatus.OK);
    }

    @GetMapping(value = "/years")
    public ResponseEntity<List<Year>> geYears() {
        return new ResponseEntity<>(epargneService.getYears(), HttpStatus.OK);
    }

    @GetMapping(value = "/types_epargnes/{year}")
    public ResponseEntity<List<TypeEpargne>> getTypesEpargnes(@PathVariable String year) {
        List<TypeEpargne> _list = epargneService.findTypeEpargnesByYear(year);
        return new ResponseEntity<>(_list, HttpStatus.OK);
    }


}
