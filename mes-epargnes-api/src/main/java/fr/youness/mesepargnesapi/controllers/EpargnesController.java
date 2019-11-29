package fr.youness.mesepargnesapi.controllers;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import fr.youness.mesepargnesapi.beans.Epargne;
import fr.youness.mesepargnesapi.beans.Totaux;
import fr.youness.mesepargnesapi.beans.TypeEpargne;
import fr.youness.mesepargnesapi.beans.Year;
import fr.youness.mesepargnesapi.services.IEpargneService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.configurationprocessor.json.JSONObject;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.*;

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
        ArrayList<Object> _list_epargnes = new ArrayList<>();
        List<TypeEpargne> _list_type_ep = epargneService.findTypeEpargnesByYear(year);
        Year _year = epargneService.findByVlue(year);
        for (TypeEpargne type_ep : _list_type_ep){
            HashMap<String, Object> map2 = new HashMap<>();
            map2.put("type", type_ep.getValue_type());
            map2.put("epargnes", epargneService.getEpargnesByTypeAndYear(type_ep, _year));
            _list_epargnes.add(map2);
        }
        return new ResponseEntity<>(_list_epargnes, HttpStatus.OK);
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

    @PostMapping(value = "/epargne")
    public ResponseEntity<Epargne> addUpdateEpargne(@RequestBody HashMap<String, String> obj) {
        Epargne _epargne = new Epargne();
        System.out.println(obj.get("id_epargne"));
        if(obj.get("id_epargne") != null) {
            _epargne.setId_epargne(Long.parseLong(obj.get("id_epargne")));
        }
        _epargne.setDate_epargne(obj.get("date_epargne"));
        _epargne.setMontant_epargne(Double.parseDouble(obj.get("montant_epargne")));
        _epargne.setMotif_epargne(obj.get("motif_epargne"));
        String _type = obj.get("type");
        TypeEpargne _type_epargne = epargneService.findTypeEpargnesByValue(_type);
        Year _active_year = epargneService.findActiveYear();
        _epargne.setType_epargne(_type_epargne);
        _epargne.setYear_epargne(_active_year);

        return new ResponseEntity<Epargne>(epargneService.addUpdateEpargne(_epargne), HttpStatus.CREATED);
    }

    @DeleteMapping(value ="/epargne/{id}")
    public ResponseEntity<?> deleteEpargne(@PathVariable Long id) {
        return new ResponseEntity<>(epargneService.deleteEpargne(id), HttpStatus.OK);
    }

    @GetMapping(value = "/epargnes/totaux/{year}")
    public ResponseEntity<?> getTotauxOfYear(@PathVariable("year") String year) {
        ArrayList<Object> _totaux_by_month_by_type = new ArrayList<>();
        List<String> array_month = Arrays.asList("01", "02","03", "04","05", "06", "07","08", "09","10", "11", "12");

        List<TypeEpargne> _list_type = epargneService.findTypeEpargnesByYear(year);
        Year _year = epargneService.findByVlue(year);
        for (TypeEpargne type_ep : _list_type){
            HashMap<String, Object> map2 = new HashMap<>();

            Map<String, Double>_totaux = new HashMap<>();
            for (String month : array_month) {
                Double  _total = epargneService.getTotauxByMonthAndType(year, month, type_ep.getId_type());
                if(_total != null) {
                    _totaux.put(month, _total);
                } else {
                    _totaux.put(month, new Double(0));
                }
            }
            map2.put("type", type_ep.getId_type());
            map2.put("totaux", _totaux);
            _totaux_by_month_by_type.add(map2);
        }
        return new ResponseEntity<>(_totaux_by_month_by_type, HttpStatus.OK);
    }

    @GetMapping(value = "/epargnes/totaux/")
    public ResponseEntity<?> getTotaux() {
        return new ResponseEntity<>(epargneService.getTotauxByTypeByYear(), HttpStatus.OK);
    }

    @PostMapping(value = "/epargnes/totaux/")
    public ResponseEntity<?> updateTotaux(@RequestBody TotalPersist obj) {
        System.out.println(obj.toString());

        return new ResponseEntity<>(epargneService.updateTotaux(Double.parseDouble(obj.solde), obj.year, Long.parseLong(obj.id_type)), HttpStatus.OK);
    }
}

class TotalPersist {
    public String solde;
    public String year;
    public String id_type;
}